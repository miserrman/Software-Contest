package com.garment.dapei.dao;

import com.garment.dapei.model.BigCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BigCategoryDao {
    int insertCategory(BigCategory bigCategory);

    void deleteCategory(int bigCategoryID);

    void updateCategory(BigCategory bigCategory);

    List<BigCategory> selectAllCategories();

    BigCategory selectCategoryByID(int categoryID);

    BigCategory selectCategoryByName(String categoryInformation);
}
