package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {
    @Test
    public void testAddOneEvent() {
        //Given
        //When
        Logger.getInstance().log("test event");
        String messageFromLog = Logger.getInstance().getLastLog();
        //Then
        Assert.assertEquals("test event", messageFromLog);
    }

    @Test
    public void testAddTwoEvents() {
        //Given
        //When
        Logger.getInstance().log("test event");
        Logger.getInstance().log("another test event");
        String messageFromLog = Logger.getInstance().getLastLog();
        //Then
        Assert.assertEquals("another test event", messageFromLog);
    }
}
