package com.garment.dapei.service;

public interface ICategoryService {
    public void eraseCategory(int userID, int clothID, String category);

    public void searchCategoryCloth(int userID, int categoryID);
}
