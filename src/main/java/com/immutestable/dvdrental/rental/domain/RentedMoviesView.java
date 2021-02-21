package com.immutestable.dvdrental.rental.domain;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RentedMoviesView {

    private final List<RentedMovieView> movieViews;

    public RentedMoviesView(List<RentedMovieView> movieViews) {
        this.movieViews = movieViews;
    }

    public List<RentedMovieView> findMatching(Predicate<RentedMovieView> filter) {
        return this.movieViews.stream().filter(filter).collect(Collectors.toList());
    }

    public int size() {
        return movieViews.size();
    }
}
