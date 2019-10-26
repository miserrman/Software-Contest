package com.garment.dapei.dao;

import com.garment.dapei.model.BigCategory;

import java.util.List;

public interface BigCategoryDao {
    void insertCategory(String categoryInformation);
    void deleteCategory(BigCategory bigCategory);
    void updateCategory(BigCategory bigCategory);
    List<BigCategory> selectAllCategories();
    BigCategory selectCategoryByID(int categoryID);
    BigCategory selectCategoryByName(String categoryInformation);
}
