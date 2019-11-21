package com.garment.dapei.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.garment.dapei.model.Clothes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/recommand")
public class RecommandController {

    /**
     *  产生多件衣服与用户衣柜的匹配
     * @param body 包含衣服列表${clothesList},和用户ID${userID}
     * @param request
     * @return 产生的搭配类
     */
    @GetMapping("/cloth")
    public String generateOutfitByCloth(@RequestBody String body, HttpServletRequest request) {
        JSONObject jsonObject = JSON.parseObject(body);
        String clothesJsonList = jsonObject.getString("clothesList");
        List<Clothes> clothesList = (List<Clothes>) JSON.parse(clothesJsonList);
        int userID = Integer.parseInt(jsonObject.getString("userID"));
        //使用service层
        return null;
    }

    /**
     * 产生基于用户衣柜的推荐
     * @param body 包含用户ID${userID}
     * @return 产生的outfit类
     */
    @GetMapping("/closet")
    public String generateOutfitByCloset(@RequestBody String body, HttpServletRequest request) {
        JSONObject jsonObject = JSON.parseObject(body);
        int userID = Integer.parseInt(jsonObject.getString("userID"));
        return null;
    }

    /**
     *  喜欢穿搭
     * @param body 包含穿搭ID${outfitID}
     */
    @GetMapping("/favor")
    public void favorOutfit(@RequestBody String body, HttpServletRequest request){
        JSONObject jsonObject = JSON.parseObject(body);
        int outfitID = Integer.parseInt(jsonObject.getString("outfitID"));
    }

    /**
     *  用户查询生成的搭配
     * @param body 包含穿搭ID${outfitID},
     * @return 一个包含穿搭和衣服列表的类
     */
    @GetMapping("/find")
    public String findCloset(@RequestBody String body, HttpServletRequest request)
    {
        JSONObject jsonObject = JSON.parseObject(body);
        int outfitID = Integer.parseInt(jsonObject.getString("outfitID"));
        return null;
    }


}
