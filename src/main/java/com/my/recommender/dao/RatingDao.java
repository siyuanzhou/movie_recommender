package com.my.recommender.dao;

import java.util.List;

import com.my.recommender.model.Rating;

public interface RatingDao {

    void insert(Rating rating);

    void update(Rating rating);

    List<Rating> getAll();

    Rating getByUserFilm(int userId, int filmId);

    double getFilmAverageRating(int filmId);

    void updateFilmAvgRating(int filmId);

}