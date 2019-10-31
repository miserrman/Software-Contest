package com.garment.dapei.dao;

import com.garment.dapei.model.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class CommentDaoTest {

    @Autowired
    CommentDao commentDao;

    @Test
    public void insertTest(){
        Comment comment = new Comment();
        Date date = new java.util.Date();
        comment.setCommentTime(date);
        comment.setOutfitID(1);
        comment.setUserID(1);
        commentDao.insertComment(comment);
    }

    @Test
    public void deleteTest(){
        commentDao.deleteComment(1);
    }

    @Test
    public void selectUserTest(){
        List<Comment>commentList = commentDao.selectCommentByUserID(1);
        System.out.println(commentList.size());
    }

    @Test
    public void selectCommentTest(){
        Comment comment = commentDao.selectCommentByOutfitID(1);
        System.out.println(comment.getUserID());
    }
}
