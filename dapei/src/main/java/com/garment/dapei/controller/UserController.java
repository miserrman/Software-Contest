package com.garment.dapei.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.garment.dapei.model.Figure;
import com.garment.dapei.model.User;
import com.garment.dapei.service.imple.UserService;
import com.garment.dapei.vo.AllUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

//使用阿里的JSON类
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 注册用户
     * @param body 包含姓名，性别，生日
     * @param request
     * @return
     */
    @PostMapping("/register")
    public String registerUser(@RequestBody String body, HttpServletRequest request){
            System.out.println(body);
            JSONObject jsonObject = JSON.parseObject(body);
            String name = jsonObject.getString("name");
            String birthday = jsonObject.getString("birthday");
            String sex = jsonObject.getString("gender");
            int gender = Integer.parseInt(sex);
            AllUserInfo allUserInfo = userService.register(name, birthday, gender);
            return JSON.toJSONString(allUserInfo);
        }

        /**
         * 对用户信息进行修改
         * @param body 完整的用户类
         * @return 完整的用户类
         */
        @PostMapping("/update/userinfo")
        public String updateUserInfo(@RequestBody String body, HttpServletRequest request) {
            User user = (User) JSON.parse(body);
            userService.update(user);
            return JSON.toJSONString(user);
        }

        /**
         *  得到用户的体形信息,创建用户即创建体形
         * @param body 包含用户ID
         * @return 用户的体形信息
         */
        @PostMapping("/figure/get")
        public String getFigure(@RequestBody String body, HttpServletRequest request){
            JSONObject jsonObject = JSON.parseObject(body);
            String userID = jsonObject.getString("userID");
            int id = Integer.parseInt(userID);
            Figure figure = userService.getFigureInfo(id);
            return JSON.toJSONString(figure);
        }

        /**
        * 对用户的体形信息进行修改
        * @param body 用户的体形类
        */
        @PostMapping("/figure/update")
        public void inputFigure(@RequestBody String body, HttpServletRequest request) {
            Figure figure = (Figure) JSON.parse(body);
            userService.inputFigureInfo(figure);
        }

    /**
     * 通过用户的名字获取用户信息，相当于登录功能
     * @param body 包含用户名
     * @param request
     * @return
     */
    @PostMapping("/get")
        public String getUserByName(@RequestBody String body, HttpServletRequest request){
            JSONObject jsonObject = JSON.parseObject(body);
            String userName = jsonObject.getString("userName");
            User user = userService.getUserInfo(userName);
            String res = JSON.toJSONString(user);
            return res;
        }

}
