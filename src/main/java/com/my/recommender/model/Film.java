package com.my.recommender.model;

public class Film {

    private int id;
    private String title;
    private String year;
    private String poster;
    private String description;
    private double avgRating;
    private double exactUserRating;
    private double exactUserPrediction;

    public Film(int id, String title, String year, String poster, String description) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.poster = poster;
        this.description = description;
    }

    public Film(String title, String year, String poster) {
        this.title = title;
        this.year = year;
        this.poster = poster;
    }

    public Film() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }

    public double getExactUserRating() {
        return exactUserRating;
    }

    public void setExactUserRating(double exactUserRating) {
        this.exactUserRating = exactUserRating;
    }

    public double getExactUserPrediction() {
        return exactUserPrediction;
    }

    public void setExactUserPrediction(double exactUserPrediction) {
        this.exactUserPrediction = exactUserPrediction;
    }

    @Override
    public String toString() {
        return "Film [id=" + id + ", title=" + title + ", year=" + year + "]";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
