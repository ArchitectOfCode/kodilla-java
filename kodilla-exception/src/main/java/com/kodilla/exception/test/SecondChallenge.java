package com.kodilla.exception.test;

public class SecondChallenge {
    public String probablyIWillThrowException(double x, double y) throws Exception {
        if(x >= 2 || x < 1 || y == 1.5) {
            throw new Exception();
        }
        return "Done!";
    }

    public static void main(String[] args) throws ExceptionHandling{
        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            String result = secondChallenge.probablyIWillThrowException(2.5, 3.6);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            throw new ExceptionHandling("My own exception.");
        } finally {
            System.out.println("Program finished.");
        }
    }
}
