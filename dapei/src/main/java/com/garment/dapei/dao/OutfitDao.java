package com.garment.dapei.dao;

import com.garment.dapei.model.OutFit;

import java.util.List;

public interface OutfitDao {

    int insertOutfit(OutFit outfit);

    void deleteOutfit(int outfitID);

    void updateOutfit(OutFit outfit);

    List<OutFit> selectAllOutfits();

    OutFit selectOutfitByID(int outfitID);

    OutFit selectOutfitByUserID(int userID);

    OutFit selectOutfitByClothesID(int clothesID);

    OutFit selectOutfitByLikeFrequency(int likefrequency);

}
