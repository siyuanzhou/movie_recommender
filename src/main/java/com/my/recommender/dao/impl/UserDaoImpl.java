package com.my.recommender.dao.impl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.my.recommender.dao.UserDao;
import com.my.recommender.model.Film;
import com.my.recommender.model.User;
import com.my.recommender.model.UserAuth;

@Repository
public class UserDaoImpl implements UserDao {

    private static final String SQL_SELECT_USER_AUTH_BY_NAME = "SELECT users.idUser, users.name, users.password, roles.role FROM users INNER JOIN roles ON users.roleId = roles.idRole WHERE users.name = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insert(User user) {
        String sql = "INSERT INTO users (name, password, roleId) VALUES (?, ?, ?)";
        Connection conn = null;
        try {
            conn = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, md5Custom(user.getPassword()));
            ps.setInt(3, 2);
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
    public List<User> getAll() {
        List<User> users = new ArrayList<User>();
        String sql = "SELECT * FROM users";
        Connection conn = null;
        try {
            conn = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getInt("idUser"), rs.getString("name"), rs.getString("password"));
                users.add(user);
            }
            rs.close();
            ps.close();
            return users;
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
    public User getById(int id) {
        String sql = "SELECT * FROM users WHERE idUser = ?";
        Connection conn = null;
        try {
            conn = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            User user = new User();
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User(rs.getInt("idUser"), rs.getString("name"), rs.getString("password"));
            }
            rs.close();
            ps.close();
            return user;
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
    public List<Film> getUserFilms(int userId) {
        List<Film> films = new ArrayList<Film>();
        String sql = "SELECT films.idFilm, films.title, films.yr, films.poster ,films.description FROM films INNER JOIN ratings ON films.idFilm = ratings.filmId "
                + "WHERE ratings.userId = ?";
        Connection conn = null;
        try {
            conn = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Film film = new Film(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                films.add(film);
            }
            rs.close();
            ps.close();
            return films;
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
    public List<Film> getUserNotWatchedFilmsWithAvgRating(int userId) {
        List<Film> films = new ArrayList<Film>();
        String sql = "SELECT films.idFilm, films.title, films.yr, films.poster, films.avgRating ,films.description FROM films "
                + "WHERE films.idFilm NOT IN ( SELECT ratings.filmId FROM ratings WHERE ratings.userId = ? )";
        Connection conn = null;
        try {
            conn = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Film film = new Film(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                film.setAvgRating(rs.getDouble(5));
                films.add(film);
            }
            rs.close();
            ps.close();
            return films;
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
    public void remove(int id) {
        String sql = "DELETE FROM users WHERE idUser = ?";
        Connection conn = null;
        try {
            conn = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
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
    public UserAuth getUserAuth(String name) {
        List<UserAuth> list = jdbcTemplate.query(SQL_SELECT_USER_AUTH_BY_NAME, new RowMapper<UserAuth>() {
            @Override
            public UserAuth mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new UserAuth(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
        }, name);
        return list.isEmpty() ? null : list.get(0);
    }

    // Custom md5 hash
    public static String md5Custom(String st) {
        MessageDigest messageDigest = null;
        byte[] digest = new byte[0];
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(st.getBytes());
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BigInteger bigInt = new BigInteger(1, digest);
        String md5Hex = bigInt.toString(16);

        while (md5Hex.length() < 32) {
            md5Hex = "0" + md5Hex;
        }
        return md5Hex;
    }

}