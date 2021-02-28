package com.immutestable.dvdrental.fees.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UnpaidFeeView {
    private int movieID;
    private LocalDateTime plannedReturnDate;

    public UnpaidFeeView(int movieID, LocalDateTime plannedReturnDate) {
        this.movieID = movieID;
        this.plannedReturnDate = plannedReturnDate;
    }
}
