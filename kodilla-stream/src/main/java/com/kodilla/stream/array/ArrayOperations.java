package com.kodilla.stream.array;

import java.security.cert.CollectionCertStoreParameters;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface ArrayOperations {
    public static double getAverage(int[] numbers) {
        //return Arrays.stream(numbers).average().getAsDouble();
        int sum = 0;
        IntStream.range(0, numbers.length)
                .forEach(System.out::println);




                //.forEach(System.out::println);

                //.forEach(s -> System.out.println(s));
        return IntStream.range(0, numbers.length).average().getAsDouble();
        /*
        IntStream.range(0, a.length)
                .forEach(i -> result[i] = a[i] * b[i]);
        */
    }
}
