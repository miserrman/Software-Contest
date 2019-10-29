package com.garment.dapei.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

//使用阿里的JSON类
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 对用户进行注册，应同时创建体形，前端应直接保存体形类
     * @param name 用户名
     * @param birthday 用户生日
     * @param sex 用户性别
     * @return 完整的用户类，存储在前端变量里
     */
    @GetMapping("/register")
    public String registerUser(String name, String birthday, String sex){
        return null;
    }

    /**
     * 对用户信息进行
     * @param userInfo
     * @return 完整的用户类
     */
    @GetMapping("/update/userinfo")
    public String updateUserInfo(String userInfo){
        return null;
    }

    /**
     *  得到用户的体形信息,创建用户即创建体形
     * @param userID 用户ID
     * @return 用户的体形信息
     */
    @GetMapping("/figure/get")
    public String getFigure(String userID){
        return null;
    }

    @GetMapping("/figure/update")
    public void inputFigure(String figureInfo){

    }
}
