package com.garment.dapei.dao;

import com.garment.dapei.model.Clothes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ClothesDaoTest {

    @Autowired
    ClothesDao clothesDao;

    @Test
    public void insertTest(){
        Clothes clothes = new Clothes();
        clothes.setImageURL("cdscdscds");
        clothes.setUserID(1);
        clothesDao.insertClothes(clothes);
        System.out.println(clothes.getClothesID());
    }

    @Test
    public void deleteTest(){
        clothesDao.deleteClothes(1);
    }

    @Test
    public void selectTest(){
        Clothes clothes = clothesDao.selectClothes(2);
        System.out.println(clothes.getClothesID());
        List<Clothes>clothesList = clothesDao.selectUserClothes(1);
        System.out.println(clothesList.size());
    }

    @Test
    public void updateTest(){
        Clothes clothes = new Clothes();
        clothes.setClothesID(1);
        clothes.setUserID(1);
        clothes.setImageURL("c23");
        clothesDao.updateClothesInfo(clothes);
    }
}
