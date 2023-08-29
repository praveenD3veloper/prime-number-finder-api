package com.praveen.primefinder.core.algorithms;

import org.junit.jupiter.api.Test;
import com.praveen.primefinder.core.PrimeFinder;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SieveOfEratosthenesParallelPrimeFinderTest {

    @Test
    public void testFindPrimeNumbersInRange() {
        PrimeFinder primeFinder = new SieveOfEratosthenesParallelPrimeFinder();
        int N = 50; // Test with a small range

        List<Integer> primes = primeFinder.findPrimeNumbersInRange(N);

        // List of primes up to 50: 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47
        assertEquals(15, primes.size());
        assertEquals(2, primes.get(0));
        assertEquals(47, primes.get(primes.size() - 1));
    }

    @Test
    public void testFindPrimeNumbersInRangeWithLargeN() {
        PrimeFinder primeFinder = new SieveOfEratosthenesParallelPrimeFinder();
        int N = 1000; // Test with a larger range

        List<Integer> primes = primeFinder.findPrimeNumbersInRange(N);

        // Expected number of primes up to 1000: 168
        assertEquals(168, primes.size());
    }

    // Add more test cases to cover edge cases, performance, and concurrency scenarios
}
