package com.immutestable.dvdrental.rental.domain;

public class MovieCannotBeReturnedError extends RuntimeException{

    public MovieCannotBeReturnedError(String userID, int movieID) {
        super(String.format("Movie %s was not rented by user %s", movieID, userID));
    }
}
