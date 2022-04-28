package com.techelevator.tenmo.dao;

import java.math.BigDecimal;
import java.security.Principal;

public interface AccountDao
{
    BigDecimal accountBalance(long userId);

}
