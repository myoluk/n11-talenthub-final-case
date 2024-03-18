package com.myoluk.exception;

public class UserReviewNotFoundException extends RuntimeException {

    public UserReviewNotFoundException(String message) {
        super(message);
    }
}
