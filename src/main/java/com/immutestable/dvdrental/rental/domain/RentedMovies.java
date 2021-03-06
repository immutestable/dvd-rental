package com.immutestable.dvdrental.rental.domain;

import com.immutestable.dvdrental.movies.domain.MovieView;
import com.immutestable.dvdrental.rental.domain.exceptions.MovieAlreadyRented;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class RentedMovies {

    private final String userID;
    final List<RentedMovieView> rented;

    public RentedMovies(String userID) {
        this(userID, Collections.emptyList());
    }

    private RentedMovies(String userID, List<RentedMovieView> movies) {
        this.userID = userID;
        rented = movies;
    }

    public RentedMovies rentMovie(MovieView movie) {
        if (movieRented(movie.getMovieId())) {
            throw new MovieAlreadyRented(userID, movie.getTitle());
        }
        List<RentedMovieView> newRented = new ArrayList<>(rented);
        newRented.add(new RentedMovieView(movie.getMovieId(), movie.getTitle()));
        return new RentedMovies(userID, newRented);
    }

    private boolean movieRented(int movieID) {
        return rented.stream().anyMatch(movie -> movie.getMovieId() == movieID);
    }

    public String getUserID() {
        return userID;
    }

    public RentedMovies returnMovie(int movieID) {
        if (!movieRented(movieID)) {
            throw new MovieCannotBeReturnedError(userID, movieID);
        }
        List<RentedMovieView> newRentedMovies = rented.stream().filter(x -> x.getMovieId() != movieID).collect(toList());
        return new RentedMovies(userID, newRentedMovies);
    }
}
