package com.immutestable.dvdrental.movies.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SavedMovie {
    int id;
    String title;
    String genre;
    int productionYear;
    int minimalAge;
}
