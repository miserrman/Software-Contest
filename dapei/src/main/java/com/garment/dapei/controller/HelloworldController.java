package com.garment.dapei.controller;

import com.garment.dapei.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldController {
    @Autowired
    UserDao userDao;
    @RequestMapping("/")
    public String hello(){
        return userDao.selectAllUsers().toString();
    }
    
}
