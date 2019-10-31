package com.garment.dapei.dao;

import com.garment.dapei.model.Collect;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectDao {

    void insertCollect(Collect collect);

    void deleteCollect(@Param("userID")int userID, @Param("outfitID")int outfitID);

    Collect selectUserCollect(int userID);
}
