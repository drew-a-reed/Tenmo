package com.techelevator.tenmo.dao;

import java.math.BigDecimal;

public interface TransferDao {

    void transferTo(long userId, BigDecimal amountToDeposit);
    void transferFrom(long userId, BigDecimal amountToWithdraw);
}
