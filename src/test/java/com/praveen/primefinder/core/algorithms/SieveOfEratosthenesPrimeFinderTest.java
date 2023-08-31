package com.praveen.primefinder.core.algorithms;

import com.praveen.primefinder.core.PrimeFinder;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class SieveOfEratosthenesPrimeFinderTest {

    @Test
    public void testFindPrimeNumbersInRange_ValidRange() {
        PrimeFinder primeFinder = new SieveOfEratosthenesPrimeFinder();
        int N = 20;

        List<Integer> primes = primeFinder.findPrimeNumbersInRange(N);

        // List of primes up to 20: 2, 3, 5, 7, 11, 13, 17, 19
        assertEquals(8, primes.size());
        assertEquals(List.of(2, 3, 5, 7, 11, 13, 17, 19), primes);
    }

    @Test
    public void testFindPrimeNumbersInRange_InvalidRange() {
        PrimeFinder primeFinder = new SieveOfEratosthenesPrimeFinder();
        int N = 1; // No prime numbers in this range

        List<Integer> primes = primeFinder.findPrimeNumbersInRange(N);

        assertTrue(primes.isEmpty());
    }

    @Test
    public void testFindPrimeNumbersInRange_LargeRange() {
        PrimeFinder primeFinder = new SieveOfEratosthenesPrimeFinder();
        int N = 1000; // Test with a larger range

        List<Integer> primes = primeFinder.findPrimeNumbersInRange(N);

        // Expected number of primes up to 1000: 168
        assertEquals(168, primes.size());
    }

    @Test
    public void testFindPrimeNumbersInRange_ZeroRange() {
        PrimeFinder primeFinder = new SieveOfEratosthenesPrimeFinder();
        int N = 0; // No prime numbers in this range

        List<Integer> primes = primeFinder.findPrimeNumbersInRange(N);

        assertTrue(primes.isEmpty());
    }

}
