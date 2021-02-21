package com.immutestable.dvdrental.movies

import com.immutestable.dvdrental.movies.domain.MovieCreatedDTO
import com.immutestable.dvdrental.movies.domain.MovieView
import com.immutestable.dvdrental.movies.domain.MoviesRepository

class InMemoryMovieRepository implements MoviesRepository {

    private Map<Integer, MovieView> movies = [:]

    @Override
    MovieCreatedDTO save(String title, String genre, int productionYear, int minimalAge) {
        def nextID = getNextID()
        this.movies[nextID] = new MovieView(nextID, title, genre, productionYear, minimalAge)
        return new MovieCreatedDTO(nextID)
    }

    @Override
    MovieView find(int movieID) {
        return movies[movieID]
    }

    int getNextID() {
        def biggestIdSoFar = movies.keySet().max() ?: 0
        return biggestIdSoFar + 1
    }
}
