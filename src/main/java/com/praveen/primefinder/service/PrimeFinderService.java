package com.praveen.primefinder.service;

import com.praveen.primefinder.core.PrimeFinder;
import com.praveen.primefinder.core.StrategySelector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PrimeFinderService {

    @Autowired
    private StrategySelector strategySelector;

    @Cacheable(value = "primeList", key = "#range" )
    public List<Integer> findPrimeNumbersInRange(int range, String algorithm){
        PrimeFinder primeFinder = strategySelector.selectStrategy(algorithm);
        return primeFinder.findPrimeNumbersInRange(range);
    }

}
