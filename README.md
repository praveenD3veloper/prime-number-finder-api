# prime-number-finder-api
## Status
[![Build Status](https://app.travis-ci.com/praveenD3veloper/prime-number-finder-api.svg?branch=main)](https://app.travis-ci.com/github/praveenD3veloper/prime-number-finder-api) [![Coverage Status](https://coveralls.io/repos/github/praveenD3veloper/prime-number-finder-api/badge.svg?branch=main)](https://coveralls.io/github/praveenD3veloper/prime-number-finder-api?branch=main)

## Introduction

This application exposes an endpoint in <http://localhost:8080/primes/{range}> that can be used to find all prime numbers up to the given range.  It returns the list in response.

The API is documented with [Swagger](http://swagger.io/) and the UI can be accessed on <http://localhost:9000/swagger-ui.html>.

The Spring Actuator can be accessed at <http://localhost:8080/actuator>.

The Response can be controlled by using the `Accept` Media type in the request.  By default JSON response will be generated.  If the `Accept` Mediatype is set to `application/xml` , the response will be automatically provided in XML format


## How to compile

Just run the following command on the project root:

    ./mvnw clean package

To execute the binary in the shell type:

    java -jar ./prime-number-finder-api/target/prime-number-finder-api-0.0.1-SNAPSHOT.jar

## Hit the endpoint

In order to access the service you must hit the endpoint `http://localhost:8080/primes/{range}` where `range` is the value up to which you want to generate prime numbers. You can also add the query parameter `algorithm` to choose from the set of primer number verification algorithms available:

  * Brute Force: This is the general and inefficient algorithm available. Request `http://localhost:8080/primes/{number}?algorithm=bruteForce` if you want to use this algorithm.
  * Sieve of Eratos Thenes: This is slightly better and more efficient than the brute force algorithm and is the default implementation if no / invalid algorithm is provided in the query parameter this one is used. Request `http://localhost:8080/primes/{number}?algorithm=SieveOfEratosthenes` or just `http://localhost:8080/primes/{range}`.
  * Sieve of Eratos Thenes in Parallel (Concurrent Implementation):  This implementation of the sieve of Eratos Thenes takes advantage of the Java multithreading feature to produce an efficient outcome in finding prime numbers. Request `http://localhost:8080/primes/{number}?algorithm=SieveOfEratosthenesInParallel`.
    

## Docker image
  DockerFile with the required steps to build an application as a container is added to the root directory.  Use the Dockerfile to build an image and deploy it as a container using the below commands.
