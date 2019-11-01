package com.garment.dapei.dao;

import com.garment.dapei.model.OutFit;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutfitDao {

    int insertOutfit(OutFit outfit);

    void deleteOutfit(int outfitID);

    void updateOutfit(OutFit outfit);

    List<OutFit> selectAllOutfits();

    OutFit selectOutfitByID(int outfitID);

    List<OutFit> selectOutfitByUserID(int userID);

    OutFit selectOutfitByLikeFrequency(int likefrequency);

}
