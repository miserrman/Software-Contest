package com.garment.dapei.service.imple;

import com.garment.dapei.dao.ClosetDao;
import com.garment.dapei.dao.ClothesDao;
import com.garment.dapei.model.Closet;
import com.garment.dapei.model.Clothes;
import com.garment.dapei.service.IClosetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClosetService implements IClosetService {
    @Autowired
    ClosetDao closetDao;

    @Autowired
    ClothesDao clothesDao;

    @Override
    public void putInCloset(int clothID, int userID) {
        Closet closet = new Closet();
        closet.setUserID(userID);
        closet.setClosetID(clothID);
        closetDao.insertCloset(closet);
    }

    @Override
    public void deleteCloth(int clothID, int userID) {
        closetDao.deleteClothFromCloset(userID, clothID);
    }

    @Override
    public List<Clothes> getCloset(int userID) {
        List<Clothes>clothesList = new ArrayList<>();
        List<Closet>closetList = closetDao.selectClosetByUser(userID);
        for(Closet closet : closetList){
            Clothes clothes = clothesDao.selectClothes(closet.getClothesID());
            clothesList.add(clothes);
        }
        return clothesList;
    }
}
