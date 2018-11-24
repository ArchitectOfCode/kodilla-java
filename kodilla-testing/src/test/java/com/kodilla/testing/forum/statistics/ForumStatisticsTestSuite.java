package com.kodilla.testing.forum.statistics;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumStatisticsTestSuite {
    Statistics statsMock = mock(Statistics.class);
    StatisticsCollector statisticCollector = new StatisticsCollector();

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Variables initialized.");
    }

    static private ArrayList<String> createCustomSizeArray(int size) {
        ArrayList<String> customSizeArray = new ArrayList<String>();
        for(int i = 0; i < size; i++) {
            customSizeArray.add("User " + i);
        }
        return customSizeArray;
    }

    @Test // when no posts
    public void testCalculateAdvStatWhenNoPosts() {
        // Given / Arrange
        when(statsMock.usersNames()).thenReturn(createCustomSizeArray(5));
        when(statsMock.postsCount()).thenReturn(0);
        when(statsMock.commentsCount()).thenReturn(11);
        // When / Act
        statisticCollector.calculateAdvStatistics(statsMock);
        // Then / Assert
        Assert.assertEquals(0.0, statisticCollector.getAvgNumberOfPostsPerUser(), 0.001);
        Assert.assertEquals(2.2, statisticCollector.getAvgNumberOfCommentsPerUser(), 0.001);
        Assert.assertEquals(0.0, statisticCollector.getAvgNumberOfCommentsPerPost(), 0.001);
    }

    @Test // when 1000 posts
    public void testCalculateAdvStatWhen1000Posts() {
        // Given / Arrange
        when(statsMock.usersNames()).thenReturn(createCustomSizeArray(5));
        when(statsMock.postsCount()).thenReturn(1000);
        when(statsMock.commentsCount()).thenReturn(11);
        // When / Act
        statisticCollector.calculateAdvStatistics(statsMock);
        // Then / Assert
        Assert.assertEquals(200.0, statisticCollector.getAvgNumberOfPostsPerUser(), 0.001);
        Assert.assertEquals(2.2, statisticCollector.getAvgNumberOfCommentsPerUser(), 0.001);
        Assert.assertEquals(0.01, statisticCollector.getAvgNumberOfCommentsPerPost(), 0.001);
    }

    @Test // when no comments
    public void testCalculateAdvStatWhenNoComments() {
        // Given / Arrange
        when(statsMock.usersNames()).thenReturn(createCustomSizeArray(5));
        when(statsMock.postsCount()).thenReturn(999);
        when(statsMock.commentsCount()).thenReturn(0);
        // When / Act
        statisticCollector.calculateAdvStatistics(statsMock);
        // Then / Assert
        Assert.assertEquals(199.8, statisticCollector.getAvgNumberOfPostsPerUser(), 0.001);
        Assert.assertEquals(0.0, statisticCollector.getAvgNumberOfCommentsPerUser(), 0.001);
        Assert.assertEquals(0.0, statisticCollector.getAvgNumberOfCommentsPerPost(), 0.001);
    }

    @Test // when less comments than posts
    public void testCalculateAdvStatWhenLessCommentsThanPosts() {
        // Given / Arrange
        when(statsMock.usersNames()).thenReturn(createCustomSizeArray(5));
        when(statsMock.postsCount()).thenReturn(789);
        when(statsMock.commentsCount()).thenReturn(211);
        // When / Act
        statisticCollector.calculateAdvStatistics(statsMock);
        // Then / Assert
        Assert.assertEquals(157.8, statisticCollector.getAvgNumberOfPostsPerUser(), 0.001);
        Assert.assertEquals(42.2, statisticCollector.getAvgNumberOfCommentsPerUser(), 0.001);
        Assert.assertEquals(0.267, statisticCollector.getAvgNumberOfCommentsPerPost(), 0.001);
    }

    @Test // when more comments than posts
    public void testCalculateAdvStatWhenMoreCommentsThanPosts() {
        // Given / Arrange
        when(statsMock.usersNames()).thenReturn(createCustomSizeArray(5));
        when(statsMock.postsCount()).thenReturn(213);
        when(statsMock.commentsCount()).thenReturn(753);
        // When / Act
        statisticCollector.calculateAdvStatistics(statsMock);
        // Then / Assert
        Assert.assertEquals(42.6, statisticCollector.getAvgNumberOfPostsPerUser(), 0.001);
        Assert.assertEquals(150.6, statisticCollector.getAvgNumberOfCommentsPerUser(), 0.001);
        Assert.assertEquals(3.535, statisticCollector.getAvgNumberOfCommentsPerPost(), 0.001);
    }

    @Test // when no users
    public void testCalculateAdvStatWhenNoUsers() {
        // Given / Arrange
        when(statsMock.usersNames()).thenReturn(createCustomSizeArray(0));
        when(statsMock.postsCount()).thenReturn(213);
        when(statsMock.commentsCount()).thenReturn(753);
        // When / Act
        statisticCollector.calculateAdvStatistics(statsMock);
        // Then / Assert
        Assert.assertEquals(0.0, statisticCollector.getAvgNumberOfPostsPerUser(), 0.001);
        Assert.assertEquals(0.0, statisticCollector.getAvgNumberOfCommentsPerUser(), 0.001);
        Assert.assertEquals(3.535, statisticCollector.getAvgNumberOfCommentsPerPost(), 0.001);
    }

    @Test // when 100 users
    public void testCalculateAdvStatWhen100Users() {
        // Given / Arrange
        when(statsMock.usersNames()).thenReturn(createCustomSizeArray(100));
        when(statsMock.postsCount()).thenReturn(213);
        when(statsMock.commentsCount()).thenReturn(753);
        // When / Act
        statisticCollector.calculateAdvStatistics(statsMock);
        // Then / Assert
        Assert.assertEquals(2.13, statisticCollector.getAvgNumberOfPostsPerUser(), 0.001);
        Assert.assertEquals(7.53, statisticCollector.getAvgNumberOfCommentsPerUser(), 0.001);
        Assert.assertEquals(3.535, statisticCollector.getAvgNumberOfCommentsPerPost(), 0.001);
    }
}
