package com.praveen.primefinder.core.algorithms;

import com.praveen.primefinder.core.PrimeFinder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
    This implementation uses brute force method to recurse through
    every possible number in the given range N to find if they
    are prime are not. But only need to check up the square root
    of the chosen number in the loop.
    Time complexity N * O(sqrt(N))
 */

public class BruteForcePrimeFinder implements PrimeFinder {
    @Override
    public List<Integer> findPrimeNumbersInRange(int N) {
            return IntStream.rangeClosed(2, N)
                    .filter(this::isPrime)
                    .boxed()
                    .collect(Collectors.toList());
        }

        private boolean isPrime(int number) {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
