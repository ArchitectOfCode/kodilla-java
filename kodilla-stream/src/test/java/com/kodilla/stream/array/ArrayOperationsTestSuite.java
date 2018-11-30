package com.kodilla.stream.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage() {
        int[] numbers = {3, 452, 52, 62, 21, 63, 63, 237, 97, 5, 95, 159, 78, 689, 75, 7, 56, 19, 94, 354};

        int sum = 0;
        double averageComputedInForLoop;
        for(int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        averageComputedInForLoop = (double)sum / numbers.length;
        System.out.println("Average computed in 'for' loop: " + averageComputedInForLoop);

        System.out.println("Average computed in Stream (static method in Interface): " + ArrayOperations.getAverage(numbers));
    }
}
