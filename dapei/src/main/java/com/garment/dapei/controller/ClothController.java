package com.garment.dapei.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.garment.dapei.model.Clothes;
import com.garment.dapei.service.imple.ClothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/cloth")
public class ClothController {

    @Autowired
    ClothService clothService;

    /**
     * 将用户自己的衣服放入衣柜
     * @param body 包含用户ID${userID}, 衣服ID${clothID}
     * @param request
     */
    @PostMapping("/closet/put")
    public void putInCloset(@RequestBody String body, HttpServletRequest request){
        JSONObject jsonObject = JSON.parseObject(body);
        String userID = jsonObject.getString("userID");
        String clothID = jsonObject.getString("clothID");
        int uid = Integer.parseInt(userID);
        int cid = Integer.parseInt(clothID);
        clothService.putInCloset(cid, uid);
    }

    /**
     * 将用户自己的衣服从衣柜里删除
     * @param body 包含用户的用户ID${userID}, 衣服ID${clothID}
     * @param request
     */
    @PostMapping("/closet/delete")
    public void deleteCloth(@RequestBody String body, HttpServletRequest request){
        JSONObject jsonObject = JSON.parseObject(body);
        int userID = Integer.parseInt(jsonObject.getString("userID"));
        int clothID = Integer.parseInt(jsonObject.getString("clothID"));
        clothService.deleteCloth(clothID, userID);
    }

    /**
     * 查询用户所有在衣柜里的衣服
     * @param body 包含用户ID${userID}
     * @return
     */
    @PostMapping("/closet/get")
    public String getUserAllCloth(@RequestBody String body, HttpServletRequest request){
        JSONObject jsonObject = JSON.parseObject(body);
        int userID = Integer.parseInt(jsonObject.getString("userID"));
        List<Clothes>clothesList = clothService.getCloset(userID);
        return JSON.toJSONString(clothesList);
    }

    /**
     * 识别衣物信息
     * @param image 衣服图片
     * @return 衣服信息
     */
    @GetMapping("/distinguish")
    public String distinguishCloth(String image){
        return null;
    }

    /**
     * 得到单件衣服的信息
     * @param clothID 衣服ID
     * @return 衣服信息
     */
    @GetMapping("/get/one")
    public String getClothInfo(String clothID){
        return null;
    }

    /**
     * 得到此用户衣柜里衣服的信息
     * @param userID 用户ID
     * @return 衣物列表
     */

    @GetMapping("/wash")
    public void washCloth(String userID, String clothID){

    }

    @GetMapping("/category/search")
    public String searchCloth(String userID, String category){
        return null;
    }

    @GetMapping("/category/erase")
    public void eraseCategory(String userID, String clothID, String category){
    }

    //@GetMapping("/color/search")

}
