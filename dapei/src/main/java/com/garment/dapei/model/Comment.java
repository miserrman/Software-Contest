package com.garment.dapei.model;

import lombok.Data;

import java.util.Date;

@Data
public class Comment {
    private int commentID;
    private Date commentTime;
    private int userID;
    private int outfitID;
}
