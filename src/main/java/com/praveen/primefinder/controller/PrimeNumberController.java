package com.praveen.primefinder.controller;

import com.praveen.primefinder.entity.Result;
import com.praveen.primefinder.service.PrimeFinderService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/primes")
@Api(value = "REST API for finding Prime numbers till N")
public class PrimeNumberController {

    private static final Logger logger = LoggerFactory.getLogger(PrimeNumberController.class);

    @Autowired
    private PrimeFinderService primeFinderService;
    @ApiOperation( notes = "This API finds and returns list of prime numbers within the given range of N",
            value = "N")
    @ApiResponses({
            @ApiResponse(code=200, message = "Success" , response = Result.class),
            @ApiResponse(code=400, message = "Bad request - invalid inputs provided"),
            @ApiResponse(code= 500, message = "Technical Error / Service Unavailable.")
    })
    @GetMapping(value = "/{range}",
            produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Result> getPrimeNumbers(
            @PathVariable("range")
            @ApiParam(
                    value = "Number upto which the service will find prime numbers",
                    required = true)
            final int range,

            @RequestParam(value = "algorithm", required = false)
            @ApiParam(
                    value = "Algorithm to use for the prime number finding",
                    required = false,
                    allowableValues = "bruteforce, sieveoferatosthenes, sieveoferatosthenesinparallel"
            )
            final String algorithm){

        if(range <= 0){
            logger.error("Invalid range provided in the request = {}", range);
            throw new IllegalArgumentException("invalid range");
        }
        logger.info("Received Request with range = {}, algorithm = {}", range, algorithm);

        Result result = new Result(range, primeFinderService.findPrimeNumbersInRange(range, algorithm));
        logger.info("Responded to the request with range = {} , algorithm = {} with response = {}", range, algorithm, result.getPrimes().toString());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
