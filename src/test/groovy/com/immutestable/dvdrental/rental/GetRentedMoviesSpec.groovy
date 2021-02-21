package com.immutestable.dvdrental.rental

class GetRentedMoviesSpec extends RentalSpec {

    def "empty rentals if when user does not exist"() {
        given:
        def moviesFacade = initializeMovies([movieID])
        def usersFacade = initializeUsers([])
        def rentals = RentalTestInitialization.build(moviesFacade, usersFacade)

        when:
        def rented = rentals.getRented(userID)

        then:
        rented.size() == 0
    }

    def "empty rentals if user has not rented anything yet"() {
        given:
        def moviesFacade = initializeMovies([])
        def usersFacade = initializeUsers([userID])
        def rentals = RentalTestInitialization.build(moviesFacade, usersFacade)

        when:
        def rented = rentals.getRented(userID)

        then:
        rented.size() == 0
    }
}
