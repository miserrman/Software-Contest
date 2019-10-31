package com.garment.dapei.dao;

import com.garment.dapei.model.Collect;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CollectDaoTest {

    @Autowired
    CollectDao collectDao;

    @Test
    void insertTest(){
        Collect collect = new Collect();
        collect.setUserID(1);
        collect.setOutfitID(1);
        collectDao.insertCollect(collect);
    }

    @Test
    void deleteTest(){
        collectDao.deleteCollect(1,1);
    }

    @Test
    void selectTest(){
        collectDao.selectUserCollect(1);
    }
}
