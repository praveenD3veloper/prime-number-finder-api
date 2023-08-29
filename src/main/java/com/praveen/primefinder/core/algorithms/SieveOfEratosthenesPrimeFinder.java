package com.praveen.primefinder.core.algorithms;

import com.praveen.primefinder.core.PrimeFinder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
    vague sieve Of Eratosthenes algorithm for finding prime numbers.
    time complexity = O(N * log(log(N)))
    space complexity = 0(N) due to  `isPrime` array
 */

public class SieveOfEratosthenesPrimeFinder implements PrimeFinder {
    @Override
        public List<Integer> findPrimeNumbersInRange(int N) {
        boolean[] isPrime = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }

        for (int p = 2; p * p <= N; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= N; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        return IntStream.rangeClosed(2, N)
                .filter(i -> isPrime[i])
                .boxed()
                .collect(Collectors.toList());
    }
}
