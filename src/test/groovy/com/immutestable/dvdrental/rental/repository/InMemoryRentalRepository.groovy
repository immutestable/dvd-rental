package com.immutestable.dvdrental.rental.repository

import com.immutestable.dvdrental.rental.domain.RentalRepository
import com.immutestable.dvdrental.rental.domain.RentedMovies

class InMemoryRentalRepository implements RentalRepository {

    private Map<String, RentedMovies> rented = [:]

    @Override
    Optional<RentedMovies> get(String userID) {
        if ( rented.containsKey(userID)) {
            return Optional.ofNullable(rented[userID])
        }
        return Optional.empty()
    }

    @Override
    void save(RentedMovies rentedMovies) {
        this.rented[rentedMovies.userID] = rentedMovies
    }
}
