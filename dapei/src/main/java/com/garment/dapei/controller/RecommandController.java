package com.garment.dapei.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recommand")
public class RecommandController {

    /**
     *  产生多件衣服与用户衣柜的匹配
     * @param userID 用户ID
     * @param clothID 多件衣服ID列表
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

    /**
     *  喜欢穿搭
     * @param outfitID
     */
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
