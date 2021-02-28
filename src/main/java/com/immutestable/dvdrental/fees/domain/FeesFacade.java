package com.immutestable.dvdrental.fees.domain;

import java.time.LocalDateTime;

public interface FeesFacade {
    void addFee(String userID, int movieID, LocalDateTime plannedReturnDate);

    FeesView getFees(String userID);
}
