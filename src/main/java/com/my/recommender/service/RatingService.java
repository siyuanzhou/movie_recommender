package com.my.recommender.service;

import com.my.recommender.model.Rating;

public interface RatingService {

    void insertRating(Rating rating);

    double getRating(int userId, int filmId);

}