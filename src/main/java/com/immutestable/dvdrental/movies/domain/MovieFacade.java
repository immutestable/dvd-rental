package com.immutestable.dvdrental.movies.domain;

import com.immutestable.dvdrental.movies.api.CreateMovieCommand;

public class MovieFacade { // TODO Facade should not be in domain?
    private final MoviesRepository repository;

    public MovieFacade(MoviesRepository repository) {
        this.repository = repository;
    }

    public MovieCreatedDTO add(CreateMovieCommand command) {
        return repository.save(
                command.getTitle(),
                command.getGenre(),
                command.getProductionYear(),
                command.getMinimalAge());
    }

    public MovieView find(int movieID) {
        MovieView movieView = repository.find(movieID);
        if (movieView == null) {
            throw new MovieNotFoundException(movieID);
        }
        return movieView;
    }
}
