package com.immutestable.dvdrental.movies.domain;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(int movieID) {
        super(String.format("movie not found: %d", movieID));
    }
}
