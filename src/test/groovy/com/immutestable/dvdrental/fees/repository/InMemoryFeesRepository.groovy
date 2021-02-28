package com.immutestable.dvdrental.fees.repository

import com.immutestable.dvdrental.fees.domain.FeesRepository
import com.immutestable.dvdrental.fees.domain.UnpaidFees

class InMemoryFeesRepository implements FeesRepository {

    private Map<String, UnpaidFees> fees = [:]

    @Override
    void save(UnpaidFees unpaidFees) {
        this.fees[unpaidFees.userID] = unpaidFees
    }

    @Override
    UnpaidFees getFees(String userID) {
        if ( fees.containsKey(userID)) {
            return fees[userID]
        }
        return new UnpaidFees(userID)
    }
}
