package com.immutestable.dvdrental.movies.domain;

public class Initialization {

    public static MovieFacade build(MoviesRepository moviesRepository) {
        return new MovieFacade(moviesRepository);
    }
}
