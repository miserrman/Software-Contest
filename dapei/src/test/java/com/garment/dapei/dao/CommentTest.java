package com.garment.dapei.dao;

import com.garment.dapei.model.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.Timestamp;
import java.text.SimpleDateFormat;

@SpringBootTest
public class CommentTest {
    @Autowired
    CommentDao commentDao;

    @Test
    public void insertTest() {
        Comment comment=new Comment();
        String  str="2019-10-28 23:22:50";
       // Timestamp ts = Timestamp.valueOf(str);
        SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss ");
        comment.setCommentTime(sdf.format(str));


    }
}
