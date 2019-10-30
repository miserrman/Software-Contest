package com.garment.dapei.dao;
import com.garment.dapei.model.BigCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BigCateDaoTest {
    @Autowired
    BigCategoryDao bigCategoryDao;

    @Test
    public void insertTest(){
        BigCategory bigCategory = new BigCategory();
        bigCategory.setCategoryInformation("music");
        bigCategoryDao.insertCategory(bigCategory);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(bigCategory.getCategoryID());
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    @Test
    public void deleteTest(){
        bigCategoryDao.deleteCategory(3);
    }
}
