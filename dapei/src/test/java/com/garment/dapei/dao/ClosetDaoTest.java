package com.garment.dapei.dao;

import com.garment.dapei.model.Closet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;

@SpringBootTest
public class ClosetDaoTest {

    @Autowired
    ClosetDao closetDao;

    @Test
    public void insertTest(){
        Closet closet = new Closet();
<<<<<<< HEAD
=======
        closet.setClothesID(1);
        closet.setUserID(1);
>>>>>>> 68404a2d4990c29cabaf3cfc970eda7c755de36e
        closetDao.insertCloset(closet);
<<<<<<< HEAD
        String a = "scdscds";
        TimeTimestamp.valueOf(a);
=======
        closet.getClosetID();
        closet.setClosetID(1);

>>>>>>> 3af41765c7cd20b1daba133ff17176c5feef82f0
    }
}
