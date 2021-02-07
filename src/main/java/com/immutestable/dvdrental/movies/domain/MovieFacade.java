package com.immutestable.dvdrental.movies.domain;

import com.immutestable.dvdrental.movies.api.CreateMovieCommand;

public class MovieFacade {
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

    public MovieDTO find(int movieID) {
        MovieDTO movieDTO = repository.find(movieID);
        if (movieDTO == null) {
            throw new MovieNotFoundException(movieID);
        }
        return movieDTO;
    }
}
