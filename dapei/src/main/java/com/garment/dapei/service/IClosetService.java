package com.garment.dapei.service;

import com.garment.dapei.model.Clothes;

import java.util.List;

public interface IClosetService {

    public void putInCloset(int clothID, int userID);

    public void deleteCloth(int clothID, int userID);

    public List<Clothes> getCloset(int userID);
}
