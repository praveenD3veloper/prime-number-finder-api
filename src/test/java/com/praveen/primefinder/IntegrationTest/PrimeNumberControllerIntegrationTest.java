package com.praveen.primefinder.IntegrationTest;


import com.praveen.primefinder.entity.Result;
import com.praveen.primefinder.service.PrimeFinderService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PrimeNumberControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

//    @MockBean
//    private PrimeFinderService primeFinderService;
//
////    @BeforeEach
////    void setUp() {
////        when(primeFinderService.findPrimeNumbersInRange(anyInt(), anyString())).thenReturn(List.of(2,3,5,7));
////    }

    @Test
    void testGetPrimeNumbers_ValidInput() throws Exception {
        int range = 10;
        String algorithm = "bruteforce";

        mockMvc.perform(MockMvcRequestBuilders.get("/primes/{range}", range)
                        .param("algorithm", algorithm)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.initial").value(range));
        // Add more assertions for the response content
    }

    @Test
    void testGetPrimeNumbers_InvalidRange() throws Exception {
        int range = -5;
        String algorithm = "bruteforce";

        mockMvc.perform(MockMvcRequestBuilders.get("/primes/{range}", range)
                        .param("algorithm", algorithm)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetPrimeNumbersIntegration() throws Exception {
         mockMvc.perform(MockMvcRequestBuilders.get("/primes/10").param("algorithm", "sieveoferatosthenes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.initial", Matchers.is(10)))
                .andExpect(jsonPath("$.primes", Matchers.hasSize(4)))
                .andExpect(jsonPath("$.primes", Matchers.contains(2, 3, 5, 7)))
                .andReturn();
    }
}

