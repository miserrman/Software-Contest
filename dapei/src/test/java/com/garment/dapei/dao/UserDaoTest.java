package com.garment.dapei.dao;
import com.garment.dapei.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserDaoTest {
    @Autowired
    UserDao userDao;

    @Test
    public void selectAllUsersTest(){
        userDao.selectAllUsers();
    }

    @Test
    public void insertTest(){
        User user = new User();
        user.setUserName("dscds");
        userDao.insertUser(user);
        System.out.println(user.getUserID());
    }

    @Test
    public void deleteTest(){
        userDao.deleteUser(1);
    }

    @Test
    public void updateTest(){
        User user = new User();
        user.setUserID(2);
        user.setUserName("ewr");
        user.setUserPhone("242341234");
        user.setUserFigureID(1);
        userDao.updateUser(user);
    }

    @Test
    public void selectTest(){
        int n = userDao.selectAllUsers().size();
        System.out.println(n);
        User user = userDao.selectUserByID(2);
        System.out.println(user.getUserName());
    }

}
