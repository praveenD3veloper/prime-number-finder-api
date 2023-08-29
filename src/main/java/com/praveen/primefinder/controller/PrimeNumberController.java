package com.praveen.primefinder.controller;

import com.praveen.primefinder.core.PrimeFinder;
import com.praveen.primefinder.core.StrategySelector;
import com.praveen.primefinder.entity.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/primes")
@Api(value = "REST API for finding Prime numbers till N")
public class PrimeNumberController {

    @Autowired
    StrategySelector strategySelector;

    @ApiOperation( notes = "This API returns finds and returns list of prime numbers within the given range of N",
            value = "N")
    @ApiResponses({
            @ApiResponse(code=200, message = "Success" , response = Result.class),
            @ApiResponse(code=400, message = "Bad request - invalid inputs provided"),
            @ApiResponse(code= 500, message = "Technical Error / Service Unavailable.")
    })
    @GetMapping(value = "/{range}")
    public ResponseEntity<Result> getPrimeNumbers(@PathVariable("range") int range,
                                                  @RequestParam(value = "algorithm", required = false) String algorithm){
        PrimeFinder primeFinder = strategySelector.selectStrategy(algorithm);
        return new ResponseEntity<>(new Result(range, primeFinder.findPrimeNumbersInRange(range)), HttpStatus.OK);
    }
}
