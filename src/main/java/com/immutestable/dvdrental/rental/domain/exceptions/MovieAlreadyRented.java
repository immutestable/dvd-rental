package com.immutestable.dvdrental.rental.domain.exceptions;

public class MovieAlreadyRented extends RuntimeException {
    public MovieAlreadyRented(String userID, String movieTitle) {
        super(String.format("User %s already rented movie '%s'", userID, movieTitle));
    }
}
