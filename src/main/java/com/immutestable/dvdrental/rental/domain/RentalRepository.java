package com.immutestable.dvdrental.rental.domain;

public interface RentalRepository {
    RentedMovies get(String userID);

    void save(RentedMovies rentedMovies);
}
