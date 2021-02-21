package com.immutestable.dvdrental.rental.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class RentedMovieView {
    private final int movieId;
    private final String title;
}
