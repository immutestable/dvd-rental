package com.immutestable.dvdrental.fees.domain;

public interface FeesRepository {
    UnpaidFees getFees(String userID);

    void save(UnpaidFees unpaidFees);
}