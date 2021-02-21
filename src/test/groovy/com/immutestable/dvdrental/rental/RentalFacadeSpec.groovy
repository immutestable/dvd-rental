package com.immutestable.dvdrental.rental

import com.immutestable.dvdrental.movies.MoviesInitialization
import com.immutestable.dvdrental.movies.api.CreateMovieCommand
import com.immutestable.dvdrental.movies.domain.MovieFacade
import com.immutestable.dvdrental.movies.domain.MovieNotFoundException
import com.immutestable.dvdrental.users.domain.User
import com.immutestable.dvdrental.rental.domain.UserNotFoundException
import com.immutestable.dvdrental.users.domain.UsersFacade
import spock.lang.Specification

class RentalFacadeSpec extends Specification {

    String userID = UUID.randomUUID().toString()
    int movieID = 1

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


    def "error when movie does not exist"() {
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

    MovieFacade initializeMovies(List<Integer> integers) {
        def facade = MoviesInitialization.build()
        integers.forEach(x -> {
            def title = UUID.randomUUID().toString()
            facade.add(new CreateMovieCommand(title, "genre", 2000, 0))
        })
        return facade
    }

    UsersFacade initializeUsers(List<String> userIDs) {
        def usersFacade = Mock(UsersFacade)
        userIDs.forEach {
            x -> usersFacade.findById(x) >> Optional.ofNullable(new User(x, "Marc", "Blanc"))
        }
        usersFacade.findById(_ as String) >> Optional.empty()
        return usersFacade
    }
}
