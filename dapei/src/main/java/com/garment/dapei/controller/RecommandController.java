package com.garment.dapei.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//还要一个表记录衣服和组合产生的联系
@RestController
@RequestMapping("/recommand")
public class RecommandController {

    /**
     *  产生单件衣服与用户衣柜的匹配
     * @param userID 用户ID
     * @param clothID 衣服ID
     * @return 产生图片的URL
     */
    @GetMapping("/cloth")
    public String generateOutfitByCloth(String userID, String clothID){
        return null;
    }

    /**
     * 产生基于用户衣柜的推荐
     * @param userID 用户ID
     * @return 产生图片的URL
     */
    @GetMapping("/closet")
    public String generateOutfitByCloset(String userID){
        return null;
    }

    @GetMapping("/favor")
    public void favorOutfit(String outfitID){

    }

    /**
     *  用户查询生成的搭配
     * @param closetID 搭配ID
     * @return 图片URL
     */
    @GetMapping("/find")
    public String findCloset(String closetID){
        return null;
    }


}
