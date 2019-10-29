package com.garment.dapei.dao;

import com.garment.dapei.model.Closet;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Repository
public interface ClosetDao {

    void insertCloset(Closet closet);

    void deleteClothFromCloset(@Param("userID")int userID, @Param("clothesID")int clothesID);

    List<Closet> selectClosetByUser(int userID);
}
