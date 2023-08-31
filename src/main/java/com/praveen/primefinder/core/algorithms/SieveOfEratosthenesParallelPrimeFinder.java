package com.praveen.primefinder.core.algorithms;

import com.praveen.primefinder.core.PrimeFinder;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SieveOfEratosthenesParallelPrimeFinder implements PrimeFinder {
    public List<Integer> findPrimeNumbersInRange(int N) {
        int numberOfChunks = 6;
        int chunkSize = (N + numberOfChunks - 1) / numberOfChunks;

        BitSet isPrime = new BitSet(N + 1);
        isPrime.set(2, N + 1);

        ExecutorService executor = Executors.newFixedThreadPool(numberOfChunks);
        List<Future<Void>> futures = new ArrayList<>();

        Object lock = new Object(); // Lock for synchronized access to shared data

        for (int chunk = 0; chunk < numberOfChunks; chunk++) {
            int start = chunk * chunkSize;
            int end = Math.min((chunk + 1) * chunkSize, N + 1);

            futures.add(executor.submit(() -> {
                sieveChunk(isPrime, start, end, lock);
                return null;
            }));
        }

        for (Future<Void> future : futures) {
            try {
                future.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();

        return IntStream.rangeClosed(2, N)
                .filter(i -> {
                    synchronized (lock) {
                        return isPrime.get(i);
                    }
                })
                .boxed()
                .collect(Collectors.toList());
    }

    private void sieveChunk(BitSet isPrime, int start, int end, Object lock) {
        for (int p = 2; p * p < end; p++) {
            if (isPrime.get(p)) {
                int firstMultiple = Math.max(2 * p, (start + p - 1) / p * p);
                for (int i = firstMultiple; i < end; i += p) {
                    synchronized (lock) {
                        isPrime.clear(i);
                    }
                }
            }
        }
    }
}
