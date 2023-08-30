package com.praveen.primefinder.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestControllerAdvice
public class CustomExceptionHandler extends RuntimeException {

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CustomError notANumber(HttpServletRequest req, NumberFormatException e) {
        return new CustomError(LocalDateTime.now(), reqUrl(req),
                HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
                "Provided range is not a number. Correct format is /primes/{range} where range is positive integer.");
    }
    @ExceptionHandler({IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CustomError invalidInput(HttpServletRequest req, IllegalArgumentException e) {

        if(e.getMessage().equals("invalid range")){
            return new CustomError(LocalDateTime.now(), reqUrl(req),
                    HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(),
                    "Invalid range provided!. Correct format is /primes/{range} where range is positive integer.");
        }
        return new CustomError(LocalDateTime.now(),  reqUrl(req), HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), e.getMessage());
    }




    private String reqUrl(HttpServletRequest req) {
        String queryParams = req.getQueryString() == null ? "" : "?" + req.getQueryString();
        return req.getRequestURL().append(queryParams).toString();
    }
}
