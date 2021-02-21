package com.immutestable.dvdrental.rental

import com.immutestable.dvdrental.rental.domain.MovieCannotBeReturnedError

class ReturningMovieSpec extends RentalSpec{
    def "successfully return rented movie"() {
        given:
        def moviesFacade = initializeMovies([movieID])
        def usersFacade = initializeUsers([userID])
        def rentals = RentalTestInitialization.build(moviesFacade, usersFacade)
        rentals.rent(userID, movieID)

        when:
        rentals.returnMovie(userID, movieID)

        then:
        def rented = rentals.getRented(userID)
        rented.size() == 0
    }
    def "error returning movie that wasn't rented by a user"() {
        given:
        def moviesFacade = initializeMovies([movieID])
        def usersFacade = initializeUsers([userID])
        def rentals = RentalTestInitialization.build(moviesFacade, usersFacade)

        when:
        rentals.returnMovie(userID, movieID)

        then:
        thrown(MovieCannotBeReturnedError)
    }

}
