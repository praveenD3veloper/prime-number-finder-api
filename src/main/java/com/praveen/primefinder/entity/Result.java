package com.praveen.primefinder.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result {

    @JsonProperty
    private long initial;

    @JsonProperty
    private List<Integer> primes;

    //default constructor added for serialization / deserialization
    public Result(){
    }

    public Result(long initial, List<Integer> primeNumberList) {
        this.initial = initial;
        this.primes = primeNumberList;
    }

    public long getInitial() {
        return initial;
    }

    public void setInitial(long initial) {
        this.initial = initial;
    }

    public List<Integer> getPrimes() {
        return primes;
    }

    public void setPrimes(List<Integer> primes) {
        this.primes = primes;
    }
}
