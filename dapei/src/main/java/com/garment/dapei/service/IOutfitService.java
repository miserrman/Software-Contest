package com.garment.dapei.service;

public interface IOutfitService {
    public String generateByOneCloth(int clothID, int userID);

    public String generateByCloset(int userID);
}
