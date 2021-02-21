package com.immutestable.dvdrental.rental.domain;

import com.immutestable.dvdrental.movies.domain.MovieFacade;
import com.immutestable.dvdrental.movies.domain.MovieView;
import com.immutestable.dvdrental.rental.api.RentalFacade;
import com.immutestable.dvdrental.users.domain.UsersFacade;

public class RentalFacadeImpl implements RentalFacade {

    private final MovieFacade movieFacade;
    private final UsersFacade usersFacade;
    private final RentalRepository rentalRepository;

    public RentalFacadeImpl(MovieFacade movieFacade, UsersFacade usersFacade, RentalRepository rentalRepository) {
        this.movieFacade = movieFacade;
        this.usersFacade = usersFacade;
        this.rentalRepository = rentalRepository;
    }

    @Override
    public void rent(String userID, int movieID) {
        RentedMovies rentedMovies = rentalRepository.get(userID);
        MovieView movie = movieFacade.find(movieID);
        rentedMovies.rentMovie(movie);
        rentalRepository.save(rentedMovies);
    }

    @Override
    public RentedMoviesView getRented(String userID) {
        RentedMovies rentedMovies = rentalRepository.get(userID);
        return rentsView(rentedMovies);
    }

    private RentedMoviesView rentsView(RentedMovies rentedMovies) {
        return new RentedMoviesView(rentedMovies.rented);
    }
}
