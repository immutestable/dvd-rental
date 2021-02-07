package com.immutestable.dvdrental.movies

import com.immutestable.dvdrental.movies.api.CreateMovieCommand
import com.immutestable.dvdrental.movies.domain.MovieFacade
import com.immutestable.dvdrental.movies.domain.MovieNotFoundException
import spock.lang.Specification

class MoviesFacadeSpec extends Specification {

    String title = "Star Wars"
    String genre = "comedy"
    int minimalAge = 10
    int productionAge = 2000
    MovieFacade movieFacade
    def createMovie = new CreateMovieCommand(title, genre, productionAge, minimalAge)

    @SuppressWarnings("unused")
    void setup() {
        movieFacade = new MovieFacade(new InMemoryMovieRepository())
    }

    def "saving and retrieving movies"() {
        when:
        def movieCreated = movieFacade.add(createMovie)

        then:
        def movie = movieFacade.find(movieCreated.movieID)
        with(movie) {
            this.title == title
            this.genre == genre
            this.minimalAge == minimalAge
            this.productionAge == productionAge
        }
    }

    def "movie not found"() {
        when:
        movieFacade.find(1)

        then:
        thrown(MovieNotFoundException)
    }

}
