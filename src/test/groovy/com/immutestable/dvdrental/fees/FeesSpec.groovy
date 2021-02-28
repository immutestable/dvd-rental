package com.immutestable.dvdrental.fees

import com.immutestable.dvdrental.fees.domain.FeesView
import spock.lang.Specification

import java.time.LocalDateTime

class FeesSpec extends Specification {

    def userID = UUID.randomUUID().toString()
    def movieID = 1

    def "add fees to a user"() {
        given:
        def feesFacade = FeesInitialization.build()
        feesFacade.addFee(userID, movieID, LocalDateTime.now())

        when:
        FeesView feesView = feesFacade.getFees(userID)

        then:
        feesView.unpaidFees().size() == 1
        feesView.userID == userID
    }

    def "return empty fees"() {
        given:
        def feesFacade = FeesInitialization.build()

        when:
        FeesView feesView = feesFacade.getFees(userID)

        then:
        feesView.unpaidFees().size() == 0
        feesView.userID == userID
    }
}
