package com.praveen.primefinder.core;

import com.praveen.primefinder.core.algorithms.BruteForcePrimeFinder;
import com.praveen.primefinder.core.algorithms.SieveOfEratosthenesParallelPrimeFinder;
import com.praveen.primefinder.core.algorithms.SieveOfEratosthenesPrimeFinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StrategyConfig {

    @Bean
    public PrimeFinder bruteForce(){
        return new BruteForcePrimeFinder();
    }
    @Bean
    public PrimeFinder SieveOfEratosthenes(){
        return new SieveOfEratosthenesPrimeFinder();
    }
    @Bean
    public PrimeFinder SieveOfEratosthenesInParallel(){
        return new SieveOfEratosthenesParallelPrimeFinder();
    }

}
