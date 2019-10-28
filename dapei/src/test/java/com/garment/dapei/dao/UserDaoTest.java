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
}
