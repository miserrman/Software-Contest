package com.garment.dapei.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Comment {
    private int commentID;
    private Timestamp commentTime;
    private int userID;
    private int outfitID;
}
