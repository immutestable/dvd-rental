package com.immutestable.dvdrental.rental

import com.immutestable.dvdrental.movies.domain.MovieNotFoundException
import com.immutestable.dvdrental.rental.domain.UserNotFoundException

class RentingMovieSpec extends RentalSpec {



    def "rent a movie"() {
        given:
        def moviesFacade = initializeMovies([movieID])
        def usersFacade = initializeUsers([userID])
        def rentals = RentalTestInitialization.build(moviesFacade, usersFacade)

        when:
        rentals.rent(userID, movieID)

        then:
        def rented = rentals.getRented(userID)
        rented.findMatching({ x -> x.movieId == movieID })*.movieId == [movieID]
        rented.size() == 1
    }


    def "error when renting not-existing movie"() {
        given:
        def moviesFacade = initializeMovies([])
        def usersFacade = initializeUsers([userID])
        def rentals = RentalTestInitialization.build(moviesFacade, usersFacade)

        when:
        rentals.rent(userID, movieID)

        then:
        thrown(MovieNotFoundException)
    }
    def "error when user does not exist"() {
        given:
        def moviesFacade = initializeMovies([movieID])
        def usersFacade = initializeUsers([])
        def rentals = RentalTestInitialization.build(moviesFacade, usersFacade)

        when:
        rentals.rent(userID, movieID)

        then:
        thrown(UserNotFoundException)
    }


}
