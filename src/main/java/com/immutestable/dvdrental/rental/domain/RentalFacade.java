package com.immutestable.dvdrental.rental.domain;

public interface RentalFacade {
    void rent(String userID, int movieID);

    RentedMoviesView getRented(String userID);

    void returnMovie(String userID, int movieID);
}
