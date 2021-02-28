package com.immutestable.dvdrental.fees.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UnpaidFee {

    private final int movieID;
    private final LocalDateTime plannedReturnDate;

    public UnpaidFee(int movieID, LocalDateTime plannedReturnDate) {
        this.movieID = movieID;
        this.plannedReturnDate = plannedReturnDate;
    }
}
