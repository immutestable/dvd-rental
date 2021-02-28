package com.immutestable.dvdrental.fees.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FeesView {

    private String userID;
    private List<UnpaidFeeView> fees;

    public List<UnpaidFeeView> unpaidFees() {
        return fees;
    }
}
