package com.garment.dapei.dao;

import com.garment.dapei.model.Closet;
import org.hibernate.validator.constraints.EAN;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.List;

@SpringBootTest
public class ClosetDaoTest {

    @Autowired
    ClosetDao closetDao;

    @Test
    public void insertTest(){
        Closet closet = new Closet();
        closet.setClothesID(1);
        closet.setUserID(1);
        closetDao.insertCloset(closet);
        System.out.println(closet.getClosetID());
    }

    @Test
    public void deleteTest(){
        closetDao.deleteClothFromCloset(1, 1);
    }

    @Test
    public void selectTest(){
        List<Closet>closetList = closetDao.selectClosetByUser(2);
        for(Closet closet : closetList)
            System.out.println(closet.getClothesID());
    }

    @Test
    public void updateTest(){
    }
}
