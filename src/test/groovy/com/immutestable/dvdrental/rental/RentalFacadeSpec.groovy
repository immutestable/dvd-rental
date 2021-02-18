package com.immutestable.dvdrental.rental

import com.immutestable.dvdrental.movies.Initialization
import com.immutestable.dvdrental.rental.api.RentalFacade
import spock.lang.Specification

class RentalFacadeSpec extends Specification {

    def "should rent a movie"() {
        given:
        def moviesFacade = Initialization.build()
//        def usersFacade = new UsersRe
        rentals = new RentalFacade(moviesFacade, users)
        when:
        def rented = rentals.rent()

        then:
        1 == 2
    }

}
