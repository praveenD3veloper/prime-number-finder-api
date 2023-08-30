package com.praveen.primefinder.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionHandlingAspect {

    private final Logger logger = LoggerFactory.getLogger(ExceptionHandlingAspect.class);

    @AfterThrowing(pointcut = "execution(* com.praveen.primefinder.*.*(..))", throwing = "ex")
    public ResponseEntity<String> handleException(Throwable ex) {
        if (ex instanceof IllegalArgumentException) {
            logger.error("Bad request - " + ex.getMessage(), ex);
            return new ResponseEntity<>("Bad request - " + ex.getMessage(), HttpStatus.BAD_REQUEST);
        } else {
            logger.error("An error occurred: " + ex.getMessage(), ex);
            return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

