package com.kodilla.stream.array;

import java.util.stream.IntStream;

public interface ArrayOperations {
    public static double getAverage(int[] numbers) {
        /*
        IntStream.of(numbers)
                .forEach(s -> System.out.println(s));
        */
        IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .forEach(s -> System.out.println(s));

        /*
        return IntStream.of(numbers).average().getAsDouble();
        */
        return IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .average()
                .getAsDouble();
    }
}
