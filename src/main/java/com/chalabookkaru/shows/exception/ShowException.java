package com.chalabookkaru.shows.exception;

import org.springframework.http.HttpStatus;

public class ShowException extends RuntimeException {

    private HttpStatus httpStatus;

    public ShowException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
