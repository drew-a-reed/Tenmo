package com.techelevator.tenmo.dao;

import java.math.BigDecimal;

public interface TransferDao {

    void transferTo(long userId, BigDecimal amountToTransfer);

}
