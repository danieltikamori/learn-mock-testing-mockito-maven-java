/*
 * Copyright (c) 2024 Daniel I. Tikamori. All rights reserved.
 */

package cc.tkmr.mockito;

import java.util.List;
import java.util.SplittableRandom;
import java.util.stream.Collectors;

// Utility class (final) for generating random numbers
public final class NumberGenerator {

    private static SplittableRandom random = new SplittableRandom();

    // Private constructor to prevent instantiation
    private NumberGenerator() {
    }

    // Utility method to generate a list of random numbers
    public static List<Integer> generateRandomNumbers(int listSize) {
       return random.ints().boxed().limit(listSize).collect(Collectors.toList());
    }

    // Utility method to generate a list of random numbers
    public static List<Integer> generateRandomNumbers() {
        return random.ints().boxed().limit(random.nextInt(10)).collect(Collectors.toList());
    }

}
