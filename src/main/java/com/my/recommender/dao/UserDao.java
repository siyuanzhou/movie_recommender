package com.my.recommender.dao;

import java.util.List;

import com.my.recommender.model.Film;
import com.my.recommender.model.User;
import com.my.recommender.model.UserAuth;

public interface UserDao {

    void insert(User user);

    List<User> getAll();

    User getById(int id);

    List<Film> getUserFilms(int userId);

    void remove(int id);

    UserAuth getUserAuth(String name);

    List<Film> getUserNotWatchedFilmsWithAvgRating(int userId);

}