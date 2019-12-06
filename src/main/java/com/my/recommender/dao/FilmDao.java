package com.my.recommender.dao;

import java.util.List;

import com.my.recommender.model.Film;
import com.my.recommender.model.User;

public interface FilmDao {

    void insert(Film film);

    List<Film> getAll();

    Film getById(int id);

    List<User> getFilmUsers(int filmId);

    void remove(int id);

    List<Film> getTopNFilmsWithAvgRating(int userId, int n);

}