package com.kodilla.stream.forumuser;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Collectors;

import static java.time.LocalDate.now;

public class ForumTestSuite {
    // Given / Arrange
    Forum testForum = new Forum();

    @Test
    public void testNumberOfMales() {
        // When / Act
        long testNumberOfMales = testForum.getUserList().stream()
                .filter(forumUser -> forumUser.getGender() == 'M')
                .count();

        // Then / Assert
        Assert.assertEquals(4, testNumberOfMales);
    }

    @Test
    public void testNumberOfFemales() {
        // When / Act
        long testNumberOfFemales = testForum.getUserList().stream()
                .filter(forumUser -> forumUser.getGender() == 'F')
                .count();

        // Then / Assert
        Assert.assertEquals(2, testNumberOfFemales);
    }

    @Test
    public void testNumberOfPostsAddedByMales() {
        // When / Act
        Integer testNumberOfPostsAddedByMales = testForum.getUserList().stream()
                .filter(forumUser -> forumUser.getGender() == 'M')
                .map(e -> e.getNumberOfPosts())
                .reduce(0, Integer::sum);

        // Then / Assert
        Assert.assertEquals(34, testNumberOfPostsAddedByMales.intValue());
    }

    @Test
    public void testNumberOfPostsAddedByFemales() {
        // When / Act
        long testNumberOfPostsAddedByFemales = testForum.getUserList().stream()
                .filter(forumUser -> forumUser.getGender() == 'F')
                .map(e -> e.getNumberOfPosts())
                .reduce(0, Integer::sum);

        // Then / Assert
        Assert.assertEquals(370, testNumberOfPostsAddedByFemales);
    }

    @Test
    public void testNumberOfUsersWhoNotAddedAnyPosts() {
        // When / Act
        long testNumberOfUsersWhoNotAddedAnyPosts = testForum.getUserList().stream()
                .filter(forumUser -> forumUser.getNumberOfPosts() == 0)
                .count();

        // Then / Assert
        Assert.assertEquals(1, testNumberOfUsersWhoNotAddedAnyPosts);
    }

    @Test
    public void testNumberOfUsersOlderThan20() {
        // When / Act
        long testNumberOfUsersOlderThan20 = testForum.getUserList().stream()
                .filter(forumUser -> forumUser.getDateOfBirth().plusYears(19).plusDays(364).isBefore(now()))
                .count();

        // Then / Assert
        Assert.assertEquals(4, testNumberOfUsersOlderThan20);
    }
}
