package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;

@RestController
@PreAuthorize("isAuthenticated()")
public class AccountController
{
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Principal principal){
        return principal.getName();
    }

    @RequestMapping(path = "/account/", method = RequestMethod.GET)
    public BigDecimal getBalance(Principal principal)
    {
        long id = userDao.findIdByUsername(principal.getName());
        return accountDao.accountBalance(id);
    }
/*
    @RequestMapping(path = "/account/deposit/{id}", method = RequestMethod.PUT)
    public void deposit(@PathVariable long id, @RequestBody BigDecimal amountToDeposit)
    {
        accountDao.add(id, amountToDeposit);
    }

    @RequestMapping(path = "/account/withdraw/{id}", method = RequestMethod.PUT)
    public void withdraw(@PathVariable long id, @RequestBody BigDecimal amountToWithdraw)
    {
        accountDao.withdrawMoney(id, amountToWithdraw);
    }*/
}
