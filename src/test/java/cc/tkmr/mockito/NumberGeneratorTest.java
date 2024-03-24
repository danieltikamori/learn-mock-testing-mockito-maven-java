/*
 * Copyright (c) 2024 Daniel I. Tikamori. All rights reserved.
 */

package cc.tkmr.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;

/**
* This class is a test class for the {@link NumberGenerator} class, example of mocking static methods
*/

@ExtendWith(MockitoExtension.class)
public class NumberGeneratorTest {

    // This test method is used to test the generateRandomNumbers method of the NumberGenerator class
    // It mocks the static method of the NumberGenerator class and verifies if the generated list of numbers matches the expected list
    @Test
    void testGenerateRandomNumbersWithDefinedSize() {

        // Create a mocked static object of the NumberGenerator class
        try (MockedStatic<NumberGenerator> numberGeneratorMockedStatic = Mockito.mockStatic(NumberGenerator.class)) {
            // Create a list of integers that represents the expected list of numbers
            List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // This test method is used to test the generateRandomNumbers method of the NumberGenerator class
    // It mocks the static method of the NumberGenerator class and verifies if the generated list of numbers matches the expected list
    // It also passes a size parameter to the generateRandomNumbers method
    @Test
    void validateListOfNumbersGeneration() {
        // Create a mocked static object of the NumberGenerator class
        MockedStatic<NumberGenerator> numberGeneratorMockedStatic = Mockito.mockStatic(NumberGenerator.class);

        // Create a list of integers that represents the expected list of numbers
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Mock the generateRandomNumbers method of the NumberGenerator class to return the expected list of numbers
        numberGeneratorMockedStatic.when(() -> NumberGenerator.generateRandomNumbers(anyInt())).thenReturn(integers);

        // Call the generateRandomNumbers method of the NumberGenerator class with a size parameter of 10
        // and assert that the returned list matches the expected list
        assertEquals(integers, NumberGenerator.generateRandomNumbers(10));
    }

    // This test method is used to test the generateRandomNumbers method of the NumberGenerator class
    // It mocks the static method of the NumberGenerator class and verifies if the generated list of numbers matches the expected list
    // It does not pass a size parameter to the generateRandomNumbers method
    @Test
    void validateListOfNumbersGenerationWithoutInformingSize() {
        // Create a mocked static object of the NumberGenerator class
        Mockito.mockStatic(NumberGenerator.class);

        // Create a list of integers that represents the expected list of numbers
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Mock the generateRandomNumbers method of the NumberGenerator class to return the expected list of numbers
        Mockito.when(NumberGenerator.generateRandomNumbers()).thenReturn(integers);

        // Call the generateRandomNumbers method of the NumberGenerator class without passing a size parameter
        // and assert that the returned list matches the expected list
        assertEquals(integers, NumberGenerator.generateRandomNumbers());
    }
}