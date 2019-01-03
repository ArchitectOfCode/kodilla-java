package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {
    @Test
    public void testCalculations() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        double sumResult = calculator.add(13.3, 4.67);
        double subResult = calculator.sub(13.3, 4.67);
        double mulResult = calculator.mul(13.3, 4.67);
        double divResult = calculator.div(13.3, 4.67);
        //Then
        Assert.assertEquals(17.97, sumResult, 0.001);
        Assert.assertEquals(8.63, subResult, 0.001);
        Assert.assertEquals(62.111, mulResult, 0.001);
        Assert.assertEquals(2.847966, divResult, 0.000001);
    }

    @Test(expected=java.lang.ArithmeticException.class)
    public void testDividingByZero() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        double divResult = calculator.div(13.3, 0);
        //Then
        //do nothing
    }
}
