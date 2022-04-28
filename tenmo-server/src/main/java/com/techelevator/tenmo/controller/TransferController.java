package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.JdbcTransferDao;
import com.techelevator.tenmo.dao.TransferDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@PreAuthorize("isAuthenticated()")
public class TransferController {

    @Autowired
    TransferDao transferDao;

/*    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(path = "/user/{id}/transferTo/{id}", method = RequestMethod.PUT)
    public void transferMoney(@PathVariable)*/
}
