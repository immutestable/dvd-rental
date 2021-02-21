package com.immutestable.dvdrental.movies

import com.immutestable.dvdrental.movies.domain.MovieFacade
import com.immutestable.dvdrental.movies.domain.MoviesRepository

class MoviesInitialization {

    static MovieFacade build() {
        return new MovieFacade(newInMemoryRepository())
    }

    private static MoviesRepository newInMemoryRepository() {
        return new InMemoryMovieRepository()
    }
}
