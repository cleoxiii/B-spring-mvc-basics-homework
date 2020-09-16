package com.thoughtworks.capacity.gtb.mvc.exception;

public class UserIsExistedException extends RuntimeException {
    public UserIsExistedException(String message) {
        super(message);
    }
}
