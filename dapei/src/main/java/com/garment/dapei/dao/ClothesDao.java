package com.garment.dapei.dao;

import com.garment.dapei.model.Clothes;
import org.apache.ibatis.annotations.Param;

public interface ClothesDao {
    void insertClothes(Clothes clothes);

    void deleteClothes(int clothID);

    void updateClothesInfo(Clothes clothes);

    void updateClothesWearFrequency(@Param("wearFrequency") int wearFrequency, @Param("clothesID") int clothesID);

    void selectClothes(int clothesID);
}
