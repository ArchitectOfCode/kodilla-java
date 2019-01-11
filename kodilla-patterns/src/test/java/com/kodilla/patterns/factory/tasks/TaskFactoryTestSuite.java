package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
    @Test
    public void testFactoryShopping() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task shopping = factory.doSomething(TaskFactory.DOSHOPING);

        //Then
        Assert.assertEquals("buy", shopping.getTaskName());
        Assert.assertFalse(shopping.isTaskExecuted());
        Assert.assertEquals("shopping", shopping.executeTask());
        Assert.assertTrue(shopping.isTaskExecuted());
    }

    @Test
    public void testFactoryPainting() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task painting = factory.doSomething(TaskFactory.PAINT);

        //Then
        Assert.assertEquals("paint", painting.getTaskName());
        Assert.assertFalse(painting.isTaskExecuted());
        Assert.assertEquals("painting", painting.executeTask());
        Assert.assertTrue(painting.isTaskExecuted());
    }

    @Test
    public void testFactoryDriving() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task driving = factory.doSomething(TaskFactory.DRIVE);

        //Then
        Assert.assertEquals("drive", driving.getTaskName());
        Assert.assertFalse(driving.isTaskExecuted());
        Assert.assertEquals("driving", driving.executeTask());
        Assert.assertTrue(driving.isTaskExecuted());
    }
}
