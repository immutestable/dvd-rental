package com.immutestable.dvdrental.rental.api;

import com.immutestable.dvdrental.rental.domain.RentedMoviesView;

public interface RentalFacade {
    void rent(String userID, int movieID);

    RentedMoviesView getRented(String userID);
}
