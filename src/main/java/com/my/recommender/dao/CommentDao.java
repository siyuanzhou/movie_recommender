package com.my.recommender.dao;

import java.util.List;

import com.my.recommender.model.Comment;

public interface CommentDao {
    void insertComment(Comment comment);

    void deleteComment(int idComment);

    List<Comment> getAllByIdFilm(int filmId);

}
