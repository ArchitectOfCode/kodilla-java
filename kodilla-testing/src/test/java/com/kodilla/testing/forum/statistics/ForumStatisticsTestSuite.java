package com.kodilla.testing.forum.statistics;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumStatisticsTestSuite {
    @Test
    public void testCalculateAdvStatistics() {
        //Given
        Statistics statsMock = mock(Statistics.class);
        ArrayList<String> usersNames = new ArrayList<String>();
        usersNames.add("John Smith");
        usersNames.add("Stevie Wonder");
        usersNames.add("Ally McBeal");
        usersNames.add("Harry Portier");
        usersNames.add("Fredie Kruger");
        usersNames.add("Philip Dickens");

        when(statsMock.usersNames()).thenReturn(usersNames);

        StatisticsCollector statsCollector = new StatisticsCollector(statsMock);



        statsCollector.calculateAdvStatistics(statsMock);
        System.out.println("Defined usernames size: " + usersNames.size());
        System.out.println("statsCollector usernames size: " + statsCollector.usersNames().size());



        //When
        int numberOfUsers = statsCollector.usersNames().size();

        //Then
        Assert.assertEquals(6, numberOfUsers);
    }
}
