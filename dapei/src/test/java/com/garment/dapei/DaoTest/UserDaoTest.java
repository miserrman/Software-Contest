package com.garment.dapei.DaoTest;
import com.garment.dapei.DapeiApplication;
import com.garment.dapei.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;

public class UserDaoTest  {
    @Autowired
    UserDao userDao;
    @Test
    public void selectAllUsersTest(){
    }
}
