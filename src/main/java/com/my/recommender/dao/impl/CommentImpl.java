package com.my.recommender.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.my.recommender.dao.CommentDao;
import com.my.recommender.model.Comment;

@Repository
public class CommentImpl implements CommentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insertComment(Comment comment) {
        // TODO Auto-generated method stub
        String sql = "INSERT INTO comment (idUser, idFilm, content) VALUES (?, ?, ?)";
        Connection conn = null;
        try {
            conn = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, comment.getIdUser());
            ps.setInt(2, comment.getIdFilm());
            ps.setString(3, comment.getContent());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public void deleteComment(int idComment) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Comment> getAllByIdFilm(int filmId) {
        // TODO Auto-generated method stub
        List<Comment> comments = new ArrayList<Comment>();
        String sql = "SELECT idUser, content FROM comment where idFilm=? order by idComment desc";
        Connection conn = null;
        try {
            conn = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, filmId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Comment comment = new Comment(rs.getInt(1), rs.getString(2));
                comments.add(comment);
            }
            rs.close();
            ps.close();
            return comments;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }

}
