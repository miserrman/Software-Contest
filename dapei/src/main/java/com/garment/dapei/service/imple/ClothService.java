package com.garment.dapei.service.imple;

import com.garment.dapei.dao.ClosetDao;
import com.garment.dapei.dao.ClothesDao;
import com.garment.dapei.model.Closet;
import com.garment.dapei.model.Clothes;
import com.garment.dapei.service.IClosetService;
import com.garment.dapei.service.IClothService;
import com.garment.dapei.service.IDistinguishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClothService implements IDistinguishService, IClothService {

    @Autowired
    ClothesDao clothesDao;

    @Override
    public Clothes distinguish(File clothImg, String fileName, int userID) {
        return null;
    }

    @Override
    public Clothes getInfo(int clothesID) {
        Clothes clothes = clothesDao.selectClothes(clothesID);
        return clothes;
    }
}
