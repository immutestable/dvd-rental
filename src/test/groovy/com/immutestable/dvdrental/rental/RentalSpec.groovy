package com.immutestable.dvdrental.rental

import com.immutestable.dvdrental.movies.MoviesInitialization
import com.immutestable.dvdrental.movies.api.CreateMovieCommand
import com.immutestable.dvdrental.movies.domain.MovieFacade
import com.immutestable.dvdrental.users.domain.User
import com.immutestable.dvdrental.users.domain.UsersFacade
import spock.lang.Specification

class RentalSpec extends Specification {

    String userID = UUID.randomUUID().toString()
    int movieID = 1

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
