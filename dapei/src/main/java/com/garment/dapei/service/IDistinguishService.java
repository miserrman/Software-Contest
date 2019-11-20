package com.garment.dapei.service;

import com.garment.dapei.model.Clothes;

import java.io.File;

public interface IDistinguishService {
    public Clothes distinguish(File clothImg, String fileName, int userID);
}
