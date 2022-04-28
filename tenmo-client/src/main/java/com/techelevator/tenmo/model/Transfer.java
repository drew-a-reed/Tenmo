package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Transfer
{

    private long toUserId;
    private long fromUserId;
    private BigDecimal amountToBeTransferred;

    public long getToUserId() {
        return toUserId;
    }

    public void setToUserId(long toUserId) {
        this.toUserId = toUserId;
    }

    public long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public BigDecimal getAmountToBeTransferred() {
        return amountToBeTransferred;
    }

    public void setAmountToBeTransferred(BigDecimal amountToBeTransferred) {
        this.amountToBeTransferred = amountToBeTransferred;
    }
}
