package com.immutestable.dvdrental.fees.domain;

import java.time.LocalDateTime;

import static java.util.stream.Collectors.toList;

public class SimpleFeesFacade implements FeesFacade {

    private FeesRepository feesRepository;

    public SimpleFeesFacade(FeesRepository feesRepository) {
        this.feesRepository = feesRepository;
    }

    @Override
    public void addFee(String userID, int movieID, LocalDateTime plannedReturnDate) {
        UnpaidFees fees = feesRepository.getFees(userID);
        fees.addFee(movieID, plannedReturnDate);
        feesRepository.save(fees);
    }

    @Override
    public FeesView getFees(String userID) {
        UnpaidFees fees = feesRepository.getFees(userID);
        return FeesView.builder()
                .userID(userID)
                .fees(fees.getFees().stream().map(fee -> new UnpaidFeeView(fee.getMovieID(), fee.getPlannedReturnDate())).collect(toList()))
                .build();
    }
}
