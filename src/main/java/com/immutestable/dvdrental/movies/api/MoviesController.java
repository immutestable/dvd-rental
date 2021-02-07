package com.immutestable.dvdrental.movies.api;

import com.immutestable.dvdrental.movies.domain.MovieFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/movies")
public class MoviesController {

    private final MovieFacade movieFacade;

    public MoviesController(MovieFacade movieFacade) {
        this.movieFacade = movieFacade;
    }

    @GetMapping("/")
    public void create(@RequestBody CreateMovieCommand movieCommand) {
        movieFacade.add(movieCommand);
    }
}
