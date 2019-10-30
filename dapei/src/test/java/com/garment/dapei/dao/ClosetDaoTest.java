package com.garment.dapei.dao;

import com.garment.dapei.model.Closet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClosetDaoTest {

    @Autowired
    ClosetDao closetDao;

    @Test
    public void insertTest(){
        Closet closet = new Closet();
        closetDao.insertCloset(closet);
        closet.getClosetID();
        closet.setClosetID(1);

    }
}
