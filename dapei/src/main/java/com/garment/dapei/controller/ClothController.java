package com.garment.dapei.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cloth")
public class ClothController {

    /**
     * 将衣服放入自己的虚拟衣柜
     * @param userID 用户ID
     * @param clothID 衣服ID
     */
    @GetMapping("/closet/put")
    public void putInCloset(String userID, String clothID){

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
    @GetMapping("/get/all")
    public String getUserAllCloth(String userID){
        return null;
    }

    @GetMapping("/wash")
    public void washCloth(String userID, String clothID){

    }

    @GetMapping("/delete")
    public void deleteCloth(String userID, String clothID){

    }
}
