package com.praveen.primefinder.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/primes")
@Api(value = "REST API for finding Prime numbers till N")
public class PrimeNumberController {

    @GetMapping(value = "/{range}")
    public List<Integer> getPrimeNumbers(@PathVariable("range") int range){
        return null;
    }
}
