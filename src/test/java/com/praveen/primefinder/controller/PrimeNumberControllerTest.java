package com.praveen.primefinder.controller;

import com.praveen.primefinder.entity.Result;
import com.praveen.primefinder.service.PrimeFinderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PrimeNumberControllerTest {

    @Mock
    private PrimeFinderService primeFinderService;

    @InjectMocks
    private PrimeNumberController primeNumberController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetPrimeNumbers_ValidInput() {
        int range = 10;
        String algorithm = "bruteforce";
        Result expectedResult = new Result(10, List.of(2, 3, 5, 7));

        when(primeFinderService.findPrimeNumbersInRange(range, algorithm)).thenReturn(List.of(2, 3, 5, 7));

        ResponseEntity<Result> response = primeNumberController.getPrimeNumbers(range, algorithm);

        assert response.getStatusCode() == HttpStatus.OK;
        assert response.getBody() != null;
        assert response.getBody().getInitial() == 10;
        assert response.getBody().getPrimes().equals(Arrays.asList(2, 3, 5, 7));
    }

    @Test
    void testGetPrimeNumbers_InvalidRange() {
        int range = -5;
        String algorithm = "bruteforce";

        assertThrows(IllegalArgumentException.class, () -> primeNumberController.getPrimeNumbers(range, algorithm));
    }
}

