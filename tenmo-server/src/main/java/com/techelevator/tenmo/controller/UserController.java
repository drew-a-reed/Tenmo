package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController
{
    @Autowired
    private UserDao userDao;

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public List<User> listUsers()
    {
        return userDao.findAll();
    }

    @RequestMapping(path = "/user/{username}", method = RequestMethod.GET)
    public int getIdByUsername(@PathVariable String username)
    {
        return userDao.findIdByUsername(username);
    }

}
