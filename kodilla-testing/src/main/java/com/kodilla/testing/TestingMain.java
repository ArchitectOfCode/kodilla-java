package com.kodilla.testing;

import com.kodilla.testing.Calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args){
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if(result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        int a = 130;
        int b = 34;

        if(Calculator.add(a, b) == 164) {
            System.out.println("Function 'add' works well!");
        } else {
            System.out.println("Function 'add' does not work correct!!");
        }

        if(Calculator.subtract(a, b) == 96) {
            System.out.println("Function 'subtract' works well!");
        } else {
            System.out.println("Function 'subtract' does not work correct!!");
        }
    }
}
