package com.my.recommender.service;

import java.util.List;

import com.my.recommender.model.Film;
import com.my.recommender.model.User;

public interface UserService {

    void insertUser(User user);

    List<Film> getUserFilmsWithAvgRatingAndUserRating(int userId);

    List<Film> getUserNotWatchedFilms(int userId);

}
