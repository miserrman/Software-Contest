package com.garment.dapei.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.jsonschema.JsonSchema;
import com.garment.dapei.config.SystemPATH;
import com.garment.dapei.model.Clothes;
import com.garment.dapei.service.imple.ClosetService;
import com.garment.dapei.service.imple.ClothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/cloth")
public class ClothController {

    @Autowired
    ClosetService closetService;

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
        closetService.putInCloset(cid, uid);
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
        closetService.deleteCloth(clothID, userID);
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
        List<Clothes>clothesList = closetService.getCloset(userID);
        return JSON.toJSONString(clothesList);
    }

    /**
     * 识别衣服图片，前端将图片上传给后端，后端进行识别
     * @param file 衣服文件
     * @param body 包含用户ID
     * @param request
     * @return 识别后的衣服类
     */
    @PostMapping("/distinguish")
    public String distinguishCloth(@RequestBody MultipartFile file, @RequestBody String body, HttpServletRequest request ) {
        String rearPath = SystemPATH.getUserFilePath();
        JSONObject jsonObject = JSON.parseObject(body);
        String userID = jsonObject.getString("userID");
        int uid = Integer.parseInt(userID);
        String fileName = rearPath + userID + "/clothes" + file.getName();
        File storedFile = new File(fileName);
        try {
            file.transferTo(storedFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Clothes clothes = clothService.distinguish(storedFile, file.getName(), uid);
        return JSON.toJSONString(clothes);
    }

    /**
     * 得到单件衣服的信息
     * @param body 包含衣服ID${clothID}
     * @return 衣服信息
     */
    @GetMapping("/get/one")
    public String getClothInfo(@RequestBody String body, HttpServletRequest request){
        JSONObject jsonObject = JSON.parseObject(body);
        String clothID = jsonObject.getString("clothID");
        int cid = Integer.parseInt(clothID);
        Clothes clothes = clothService.getInfo(cid);
        return JSON.toJSONString(clothes);
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
