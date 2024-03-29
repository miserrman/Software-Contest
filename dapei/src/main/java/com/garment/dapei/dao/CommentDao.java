package com.garment.dapei.dao;

import com.garment.dapei.model.Comment;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface CommentDao {

    List<Comment> selectAllComments();

    Comment selectCommentByID(int commentID);

    Comment selectCommentByTime(Timestamp commentTime);

    List<Comment> selectCommentByUserID(int userID);

    Comment selectCommentByOutfitID(int outfitID);

    int insertComment(Comment comment);

    void deleteComment(int commentID);

    void updateComment(Comment comment);

}
