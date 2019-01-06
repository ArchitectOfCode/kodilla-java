package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {
    @Test
    public void testGetFileName() {
        //Given
        //When
        Logger.getInstance().log("test event");
        String messageFromLog = Logger.getInstance().getLastLog();
        //Then
        Assert.assertEquals("test event", messageFromLog);
    }
}
