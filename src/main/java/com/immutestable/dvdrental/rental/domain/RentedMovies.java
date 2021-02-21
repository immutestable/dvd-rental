package com.immutestable.dvdrental.rental.domain;

import com.immutestable.dvdrental.movies.domain.MovieView;

import java.util.ArrayList;
import java.util.List;

public class RentedMovies {

    private final String userID;
    final List<RentedMovieView> rented;

    public RentedMovies(String userID) {
        this.userID = userID;
        rented = new ArrayList<>();
    }

    public void rentMovie(MovieView movie) {
        rented.add(new RentedMovieView(movie.getMovieId(), movie.getTitle()));
    }

    public String getUserID() {
        return userID;
    }
}
