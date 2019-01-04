package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BoardTestSuite {
    @Test
    public void testToDoList() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        //When
        boolean ifToDoListExist = context.containsBean("toDoList");
        //Then
        Assert.assertTrue(ifToDoListExist);
    }

    @Test
    public void testInProgressList() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        //When
        boolean ifInProgressListExist = context.containsBean("inProgressList");
        //Then
        Assert.assertTrue(ifInProgressListExist);
    }

    @Test
    public void testDoneList() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        //When
        boolean ifDoneListExist = context.containsBean("doneList");
        //Then
        Assert.assertTrue(ifDoneListExist);
    }

    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        TaskList toDoList = context.getBean(TaskList.class);
        TaskList inProgressList = context.getBean(TaskList.class);
        TaskList doneList = context.getBean(TaskList.class);
        //When
        toDoList.addTask("Task to do");
        inProgressList.addTask("Task in progress");
        doneList.addTask("Done task");
        Board board = new Board(toDoList, inProgressList, doneList);
        String toDoTask = board.getToDoList().getTasks().get(0);
        String inProgressTask = board.getInProgressList().getTasks().get(0);
        String doneTask = board.getDoneList().getTasks().get(0);
        //Then
        Assert.assertEquals("Task to do", toDoTask);
        Assert.assertEquals("Task in progress", inProgressTask);
        Assert.assertEquals("Done task", doneTask);
    }
}
