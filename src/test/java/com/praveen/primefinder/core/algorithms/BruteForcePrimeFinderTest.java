package com.praveen.primefinder.core.algorithms;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BruteForcePrimeFinderTest {

    @Test
    void testFindPrimeNumbersInRange() {
        BruteForcePrimeFinder primeFinder = new BruteForcePrimeFinder();

        // Test case for range 0 to 10
        List<Integer> primes1To10 = primeFinder.findPrimeNumbersInRange(10);
        assertEquals(List.of(2, 3, 5, 7), primes1To10);

        // Test case for range 0 to 30
        List<Integer> primes1To30 = primeFinder.findPrimeNumbersInRange(30);
        assertEquals(List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29), primes1To30);

        // Test case for range 0 to 50
        List<Integer> primes1To50 = primeFinder.findPrimeNumbersInRange(50);
        assertEquals(List.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47), primes1To50);

        //Test case for range less than 2
        List<Integer> primes1To2 = primeFinder.findPrimeNumbersInRange(1);
        assertTrue(primes1To2.isEmpty());

    }
}
