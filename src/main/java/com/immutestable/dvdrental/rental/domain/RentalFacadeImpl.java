package com.immutestable.dvdrental.rental.domain;

import com.immutestable.dvdrental.movies.domain.MovieFacade;
import com.immutestable.dvdrental.movies.domain.MovieView;
import com.immutestable.dvdrental.users.domain.UsersFacade;

import java.util.Optional;

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
    public RentedMoviesView getRented(String userID) {
        return rentsView(rentalRepository.get(userID).orElse(new RentedMovies(userID)));
    }

    @Override
    public void rent(String userID, int movieID) {
        RentedMovies rentedMovies = rentalRepository.get(userID).orElse(new RentedMovies(userID));
        usersFacade.findById(userID).orElseThrow(() -> new UserNotFoundException(userID));

        MovieView movie = movieFacade.find(movieID);
        RentedMovies newRentedMovies = rentedMovies.rentMovie(movie);
        rentalRepository.save(newRentedMovies);
    }

    @Override
    public void returnMovie(String userID, int movieID) {
        RentedMovies rentedMovies = rentalRepository.get(userID).orElse(new RentedMovies(userID));
        RentedMovies newRentedMovies = rentedMovies.returnMovie(movieID);
        rentalRepository.save(newRentedMovies);
    }

    private RentedMoviesView rentsView(RentedMovies rentedMovies) {
        return new RentedMoviesView(rentedMovies.rented);
    }
}
