package com.my.recommender.service;

public interface RecommenderService {

    double getPrediction(int userId, int filmId);

}