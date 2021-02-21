package com.immutestable.dvdrental.rental.domain.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String userID) {
        super(String.format("User %s not found", userID));
    }
}
