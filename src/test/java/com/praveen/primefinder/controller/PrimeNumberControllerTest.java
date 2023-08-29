package com.praveen.primefinder.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.praveen.primefinder.core.PrimeFinder;
import com.praveen.primefinder.core.StrategySelector;
import com.praveen.primefinder.entity.Result;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PrimeNumberControllerTest {

    @Mock
    private StrategySelector strategySelector;

    @InjectMocks
    private PrimeNumberController primeNumberController;

    @Test
    public void testGetPrimeNumbers() {
        PrimeFinder primeFinderMock = mock(PrimeFinder.class);
        when(strategySelector.selectStrategy(anyString())).thenReturn(primeFinderMock);
        when(primeFinderMock.findPrimeNumbersInRange(10)).thenReturn(Arrays.asList(2, 3, 5, 7));

        ResponseEntity<Result> response = primeNumberController.getPrimeNumbers(10, "sieveoferatosthenes");

        verify(strategySelector).selectStrategy("sieveoferatosthenes");
        verify(primeFinderMock).findPrimeNumbersInRange(10);

        assert response.getStatusCode() == HttpStatus.OK;
        assert response.getBody() != null;
        assert response.getBody().getInitial() == 10;
        assert response.getBody().getPrimes().equals(Arrays.asList(2, 3, 5, 7));
    }
}
