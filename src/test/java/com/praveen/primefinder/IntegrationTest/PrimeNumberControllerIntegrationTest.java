package com.praveen.primefinder.IntegrationTest;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PrimeNumberControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetPrimeNumbersIntegration() throws Exception {
        MvcResult result = mockMvc.perform(get("/primes/10").param("algorithm", "sieveoferatosthenes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.initial", Matchers.is(10)))
                .andExpect(jsonPath("$.primes", Matchers.hasSize(4)))
                .andExpect(jsonPath("$.primes", Matchers.contains(2, 3, 5, 7)))
                .andReturn();
    }
}
