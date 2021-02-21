package com.immutestable.dvdrental.rental.domain;

import java.util.Optional;

public interface RentalRepository {
    Optional<RentedMovies> get(String userID);

    void save(RentedMovies rentedMovies);
}
