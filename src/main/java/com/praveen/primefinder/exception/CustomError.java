package com.praveen.primefinder.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

import java.util.Objects;

@ApiModel(description = "CustomError Template")
public class CustomError {

   // @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private LocalDateTime timestamp;
    private String url;

    private int statusCode;

    private String statusName;

    private String message;

    public CustomError() {}

    public CustomError(LocalDateTime timestamp, String url, int statusCode, String statusName, String message) {
        this.timestamp = timestamp;
        this.url = url;
        this.statusCode = statusCode;
        this.statusName = statusName;
        this.message = message;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @ApiModelProperty("Request URL")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @ApiModelProperty("Error Msg")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        CustomError other = (CustomError) obj;
        return Objects.equals(this.url, other.url) && Objects.equals(this.message, other.message);
    }

    @Override
    public String toString() {
        return "ErrorInfo {" +
                "url: '" +
                url +
                "', message: '" +
                message +
                "'}";
    }
}
