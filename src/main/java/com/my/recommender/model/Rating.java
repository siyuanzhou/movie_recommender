package com.my.recommender.model;

public class Rating {

    private int id;
    private int userId;
    private int filmId;
    private double rating;

    public Rating(int id, int userId, int filmId, double rating) {
        this.id = id;
        this.userId = userId;
        this.filmId = filmId;
        this.rating = rating;
    }

    public Rating(int userId, int filmId, double rating) {
        this.userId = userId;
        this.filmId = filmId;
        this.rating = rating;
    }

    public Rating() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Rating [id=" + id + ", userId=" + userId + ", filmId=" + filmId + ", rating=" + rating + "]";
    }

}
