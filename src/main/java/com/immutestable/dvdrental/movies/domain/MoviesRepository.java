package com.immutestable.dvdrental.movies.domain;

public interface MoviesRepository {
    MovieCreatedDTO save(String title, String genre, int productionYear, int minimalAge);
    MovieView find(int movieID);
}
