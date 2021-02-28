package com.immutestable.dvdrental.fees.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class UnpaidFees {

    @Id
    private final String userID;
    private List<UnpaidFee> fees;

    public UnpaidFees(String userID) {
        this.userID = userID;
        this.fees = new ArrayList<>();
    }

    public void addFee(int movieID, LocalDateTime plannedReturnDate) {
        this.fees.add(new UnpaidFee(movieID, plannedReturnDate));
    }
}
