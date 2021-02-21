package com.immutestable.dvdrental.rental

import com.immutestable.dvdrental.rental.domain.RentalRepository
import com.immutestable.dvdrental.rental.domain.RentedMovies

class InMemoryRentalRepository implements RentalRepository {

    private Map<String, RentedMovies> rented = [:]

    @Override
    RentedMovies get(String userID) {
        if ( rented.containsKey(userID)) {
            return rented[userID]
        }
        return new RentedMovies(userID)
    }

    @Override
    void save(RentedMovies rentedMovies) {
        this.rented[rentedMovies.userID] = rentedMovies
    }
}
