package com.praveen.primefinder.exception;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CustomErrorTest {

    @Test
    void testEquals_SameObject() {
        LocalDateTime timestamp = LocalDateTime.now();
        String url = "http://example.com";
        int statusCode = 400;
        String statusName = "Bad Request";
        String message = "Invalid input";

        CustomError error = new CustomError(timestamp, url, statusCode, statusName, message);

        assertEquals(error, error);
    }

    @Test
    void testEquals_EqualObjects() {
        LocalDateTime timestamp1 = LocalDateTime.now();
        String url1 = "http://example.com";
        int statusCode1 = 400;
        String statusName1 = "Bad Request";
        String message1 = "Invalid input";

        LocalDateTime timestamp2 = LocalDateTime.now();
        String url2 = "http://example.com";
        int statusCode2 = 400;
        String statusName2 = "Bad Request";
        String message2 = "Invalid input";

        CustomError error1 = new CustomError(timestamp1, url1, statusCode1, statusName1, message1);
        CustomError error2 = new CustomError(timestamp2, url2, statusCode2, statusName2, message2);

        assertEquals(error1, error2);
        assertEquals(error2, error1);
    }

    @Test
    void testEquals_DifferentObjects() {
        LocalDateTime timestamp1 = LocalDateTime.now();
        String url1 = "http://example.com";
        int statusCode1 = 400;
        String statusName1 = "Bad Request";
        String message1 = "Invalid input";

        LocalDateTime timestamp2 = LocalDateTime.now();
        String url2 = "http://another-example.com";
        int statusCode2 = 500;
        String statusName2 = "Internal Server Error";
        String message2 = "Something went wrong";

        CustomError error1 = new CustomError(timestamp1, url1, statusCode1, statusName1, message1);
        CustomError error2 = new CustomError(timestamp2, url2, statusCode2, statusName2, message2);

        assertNotEquals(error1, error2);
        assertNotEquals(error2, error1);
    }
}

