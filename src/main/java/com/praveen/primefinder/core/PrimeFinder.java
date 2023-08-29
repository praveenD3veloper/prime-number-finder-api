package com.praveen.primefinder.core;

import java.util.List;

public interface PrimeFinder {
    /**
     * @param N is the range end for finding prime numbers
     * @return List of prime numbers found in the range
     */
    List<Integer> findPrimeNumbersInRange(int N);

}
