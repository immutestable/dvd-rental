package com.immutestable.dvdrental.movies.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateMovieCommand {
    String title;
    String genre;
    int productionYear;
    int minimalAge;
}
