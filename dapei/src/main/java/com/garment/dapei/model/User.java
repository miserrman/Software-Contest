package com.garment.dapei.model;

import lombok.Data;

import java.sql.Date;

@Data
public class User {
    private int userID;
    private String userName;
    private int userSex;
    private Date userBirthday;
    private String userPhone;
    private String userImage;
    private int userHaircut;
    private int userSkinColor;
}
