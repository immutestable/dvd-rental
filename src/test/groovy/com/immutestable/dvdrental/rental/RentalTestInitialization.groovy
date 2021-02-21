package com.immutestable.dvdrental.rental

import com.immutestable.dvdrental.movies.domain.MovieFacade
import com.immutestable.dvdrental.rental.api.RentalFacade
import com.immutestable.dvdrental.rental.domain.RentalFacadeImpl
import com.immutestable.dvdrental.users.domain.UsersFacade

class RentalTestInitialization {
    static RentalFacade build(MovieFacade movieFacade, UsersFacade usersFacade) {
        return new RentalFacadeImpl(movieFacade, usersFacade, new InMemoryRentalRepository())
    }
}
