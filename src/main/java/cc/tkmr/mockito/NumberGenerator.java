/*
 * Copyright (c) 2024 Daniel I. Tikamori. All rights reserved.
 */

package cc.tkmr.mockito;

import java.util.List;
import java.util.SplittableRandom;
import java.util.stream.Collectors;

public final class NumberGenerator {

    private static SplittableRandom random = new SplittableRandom();

    private NumberGenerator() {
    }

    public static List<Integer> generateRandomNumbers(int listSize) {
       return random.ints().boxed().limit(listSize).collect(Collectors.toList());
    }

    public static List<Integer> generateRandomNumbers() {
        return random.ints().boxed().limit(random.nextInt(10)).collect(Collectors.toList());
    }

}
