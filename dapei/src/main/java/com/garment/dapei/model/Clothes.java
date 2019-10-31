package com.garment.dapei.model;

import lombok.Data;

@Data
public class Clothes {
    private int styleID;
    private int wearFrequency;
    private int clothesID;
    private String clothesColor;
    private String clothesSize;
    private String season;
    private int categoryID;
    private String imageURL;
    private String likeAbility;
    private int userID;

}


