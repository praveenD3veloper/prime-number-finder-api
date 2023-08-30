package com.praveen.primefinder.service;

import com.praveen.primefinder.core.PrimeFinder;
import com.praveen.primefinder.core.StrategySelector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PrimeFinderServiceTest {

    @Mock
    private StrategySelector strategySelector;

    @Mock
    private PrimeFinder primeFinder;

    @InjectMocks
    private PrimeFinderService primeFinderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindPrimeNumbersInRange_ValidInput() {
        int range = 10;
        String algorithm = "bruteforce";
        List<Integer> expectedPrimeNumbers = List.of(2,3,5,7); // Initialize with expected data

        when(strategySelector.selectStrategy(algorithm)).thenReturn(primeFinder);
        when(primeFinder.findPrimeNumbersInRange(range)).thenReturn(expectedPrimeNumbers);

        List<Integer> primeNumbers = primeFinderService.findPrimeNumbersInRange(range, algorithm);

        assertNotNull(primeNumbers);
        assertEquals(expectedPrimeNumbers, primeNumbers);
    }

    }

