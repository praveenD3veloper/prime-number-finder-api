package com.praveen.primefinder.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

@Component
public class StrategySelector {

    private static final Logger logger = LoggerFactory.getLogger(StrategySelector.class);

    @Autowired
    @Qualifier("bruteForce")
    private PrimeFinder bruteForcePrimeFinder;

    @Autowired
    @Qualifier("SieveOfEratosthenes")
    private PrimeFinder sieveOfEratosthenesPrimeFinder;

    @Autowired
    @Qualifier("SieveOfEratosthenesInParallel")
    private PrimeFinder SieveOfEratosthenesInParallelPrimeFinder;

    private Map<String, Supplier<PrimeFinder>> strategyMap;

    @PostConstruct
    public void initializeStrategyMap() {
        strategyMap = new HashMap<>();
        strategyMap.put("bruteforce", () -> bruteForcePrimeFinder);
        strategyMap.put("sieveoferatosthenes", () -> sieveOfEratosthenesPrimeFinder);
        strategyMap.put("sieveoferatosthenesinparallel", () -> SieveOfEratosthenesInParallelPrimeFinder);
        // Add other strategies to the map
    }

    /*
    This method selects the strategy based on the algorithm provided as a parameter
    in the request.  If the provided algorithm is not matched then it proceeds
    to use sieve of eratosthenes as a default one
     */
    public PrimeFinder selectStrategy(String requestedStrategy) {
        if (requestedStrategy == null) {
            logger.warn("Requested strategy is null, using default strategy (sieveOfEratosthenes)");
            return sieveOfEratosthenesPrimeFinder;
        }
        Supplier<PrimeFinder> strategySupplier = strategyMap.getOrDefault(requestedStrategy.toLowerCase(), () -> {
            logger.warn("requested strategy: {} is invalid, using default strategy (sieveOfEratosthenes)", requestedStrategy);
            return sieveOfEratosthenesPrimeFinder;
        });

        logger.info("Algorithm used = {}",requestedStrategy);

        return strategySupplier.get();
    }
}
