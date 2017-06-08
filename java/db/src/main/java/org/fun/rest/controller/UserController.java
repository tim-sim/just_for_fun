package org.fun.rest.controller;

import org.fun.data.repository.UserDao;
import org.fun.rest.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by tim on 03.06.2017.
 */
@RestController
public class UserController {
    @Autowired
    private UserDao userDao;

    @GetMapping
    public List<UserDto> getUsers() {
        return userDao.findAll();
    }

}
