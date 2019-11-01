package com.garment.dapei.dao;

import com.garment.dapei.model.OutFit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class OutfitDDaoTest {

    @Autowired
    OutfitDao outfitDao;

    @Test
    public void insertTest(){
        OutFit outFit = new OutFit();
        outFit.setUserID(1);
        outFit.setLikeFrequency(0);
        outfitDao.insertOutfit(outFit);
    }

    @Test
    public void deleteTest(){
        outfitDao.deleteOutfit(1);
    }

    @Test
    public void updateTest(){
        OutFit outFit = new OutFit();
        outFit.setOutfitID(2);
        outFit.setUserID(1);
        outFit.setLikeFrequency(3);
        outfitDao.updateOutfit(outFit);
    }

    @Test
    public void selectTest(){
        int n = outfitDao.selectAllOutfits().size();
        System.out.println(n);
        List<OutFit>outFitList = outfitDao.selectOutfitByUserID(1);
        System.out.println(outFitList.size());
    }

}
