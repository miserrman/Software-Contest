package com.garment.dapei.service;

import com.garment.dapei.model.Figure;

public interface IFigureInfo {

    public Figure get(int figureID);

    public void input(Figure figure);
}
