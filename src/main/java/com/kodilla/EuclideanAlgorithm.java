package com.kodilla;

import java.util.Scanner;

public class EuclideanAlgorithm {
    // the division-based version
    public static int computeGCDDiv(int a, int b) {
        int t;
        while(b != 0) {
            t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    // the subtraction-based version
    public static int computeGCDSub(int a, int b) {
        while(a != b) {
            if(a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    // the recursive version
    public static int computeGCDRec(int a, int b) {
        if(b == 0) {
            return a;
        } else {
            return computeGCDRec(b, a % b);
        }
    }

    public static void main(String args[]) {
        int a, b;
        Scanner scan = new Scanner(System.in);

        System.out.println("Computing the greatest common divisor (GCD) of two numbers by three versions on Euclid's algorithm.\n");

        System.out.print("Provide first number (integer): ");
        a = scan.nextInt();
        System.out.print("Provide second number (integer): ");
        b = scan.nextInt();

        System.out.println("\nThe greatest common divisor (GCD) of " + a + " and " + b);
        System.out.println("Computed by the division-based version: " + computeGCDDiv(a, b));
        System.out.println("Computed by the subtraction-based version: " + computeGCDSub(a, b));
        System.out.println("Computed by the recursive version: " + computeGCDRec(a, b));

    }
}

// https://en.wikipedia.org/wiki/Euclidean_algorithm#Implementations