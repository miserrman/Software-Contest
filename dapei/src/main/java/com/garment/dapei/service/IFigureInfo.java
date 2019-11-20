package com.garment.dapei.service;

import com.garment.dapei.model.Figure;

public interface IFigureInfo {

    public Figure getFigureInfo(int figureID);

    public void inputFigureInfo(Figure figure);
}
