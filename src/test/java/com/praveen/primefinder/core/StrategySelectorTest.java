package com.praveen.primefinder.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class StrategySelectorTest {

    @Mock
    private PrimeFinder bruteForcePrimeFinder;

    @Mock
    private PrimeFinder sieveOfEratosthenesPrimeFinder;

    @Mock
    private PrimeFinder SieveOfEratosthenesInParallelPrimeFinder;

    @InjectMocks
    private StrategySelector strategySelector;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        strategySelector.initializeStrategyMap();
    }

    @Test
    public void testSelectStrategyWithValidStrategy() {
        String validStrategy = "bruteforce";
        when(bruteForcePrimeFinder.findPrimeNumbersInRange(anyInt())).thenReturn(Arrays.asList(2, 3, 5, 7));

        List<Integer> primeNumbers = bruteForcePrimeFinder.findPrimeNumbersInRange(10);
        PrimeFinder selectedStrategy = strategySelector.selectStrategy(validStrategy);

        assertEquals(bruteForcePrimeFinder, selectedStrategy);
        verify(bruteForcePrimeFinder, times(1)).findPrimeNumbersInRange(anyInt());
        verifyNoMoreInteractions(sieveOfEratosthenesPrimeFinder, SieveOfEratosthenesInParallelPrimeFinder);
    }

    @Test
    public void testSelectStrategyWithNullStrategy() {
        PrimeFinder selectedStrategy = strategySelector.selectStrategy(null);

        assertEquals(sieveOfEratosthenesPrimeFinder, selectedStrategy);
        verifyNoMoreInteractions(bruteForcePrimeFinder, SieveOfEratosthenesInParallelPrimeFinder);
    }

    @Test
    public void testSelectStrategyWithInvalidStrategy() {
        String invalidStrategy = "invalid";
        PrimeFinder selectedStrategy = strategySelector.selectStrategy(invalidStrategy);

        assertEquals(sieveOfEratosthenesPrimeFinder, selectedStrategy);
        verifyNoMoreInteractions(bruteForcePrimeFinder, SieveOfEratosthenesInParallelPrimeFinder);
    }
}


