package com.garment.dapei.dao;

import com.garment.dapei.model.Figure;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FigureDao {

    int insertUserFigure(Figure figure);

    void updateUserFigure(Figure figure);

    Figure selectUserFigure(int figureID);
}
