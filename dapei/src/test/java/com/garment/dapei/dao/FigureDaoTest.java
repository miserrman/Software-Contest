package com.garment.dapei.dao;

import com.garment.dapei.model.Figure;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FigureDaoTest {

    @Autowired
    FigureDao figureDao;

    @Test
    public void insertTest(){
        Figure figure = new Figure();
        figure.setHeight(100);
        figure.setWeight(60);
        figureDao.insertUserFigure(figure);
        System.out.println(figure.getFigureID());
    }

    @Test
    public void updateTest(){
        Figure figure = new Figure();
        figure.setFigureID(1);
        figure.setUserHaircut(1);
        figure.setWeight(50);
        figure.setHeight(30);
        figureDao.updateUserFigure(figure);
    }

    @Test
    public void selectTest(){
        Figure figure = figureDao.selectUserFigure(1);
        System.out.println(figure.getHeight());
    }

}
