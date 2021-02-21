package com.immutestable.dvdrental.rental.domain;

import com.immutestable.dvdrental.movies.domain.MovieFacade;
import com.immutestable.dvdrental.users.domain.UsersFacade;

public class Initialization {
    public static RentalFacade build(MovieFacade movieFacade, UsersFacade usersFacade) {
        return new RentalFacadeImpl(movieFacade, usersFacade, null); // TODO add real repository implementation
    }
}
