package com.immutestable.dvdrental.movies.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MovieView {
    int movieId;
    String title;
    String genre;
    int productionYear;
    int minimalAge;
}
