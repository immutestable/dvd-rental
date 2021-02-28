package com.immutestable.dvdrental.fees

import com.immutestable.dvdrental.fees.domain.FeesFacade
import com.immutestable.dvdrental.fees.domain.FeesRepository
import com.immutestable.dvdrental.fees.domain.SimpleFeesFacade
import com.immutestable.dvdrental.fees.repository.InMemoryFeesRepository

class FeesInitialization {

    static FeesFacade build() {
        return new SimpleFeesFacade(newInMemoryRepository())
    }

    private static FeesRepository newInMemoryRepository() {
        return new InMemoryFeesRepository()
    }

}
