package com.my.recommender.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.recommender.Recommender.Recommender;
import com.my.recommender.dao.RatingDao;
import com.my.recommender.model.Rating;
import com.my.recommender.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingDao ratingDao;

    @Autowired
    private Recommender rec;

    @Override
    public double getRating(int userId, int filmId) {
        return ratingDao.getByUserFilm(userId, filmId).getRating();
    }

    @Override
    public void insertRating(Rating rating) {
        boolean error = false;
        try {
            rec.getRecommender().setPreference(rating.getUserId(), rating.getFilmId(), (float) rating.getRating());
        } catch (Exception e) {
            error = true;
            ratingDao.insert(rating);
            rec.renewRecommender();
        }
        if (error == false) {
            ratingDao.insert(rating);
        }
    }
}