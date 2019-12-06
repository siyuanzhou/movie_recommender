package com.my.recommender.service;

import java.util.List;

import com.my.recommender.model.Comment;
import com.my.recommender.model.Film;

public interface FilmService {

    List<Film> getAllFilms();

    List<Film> getAllFilmsWithAvgRating();

    Film getFilmById(int filmId);

    Film getFilmByIdWithAvgRatingAndUserRating(int userId, int filmId);

    List<Film> getTopRecommended(int userId, int howMuch);

    List<Film> getTopNFilmsWithAvgRating(int userId, int n);

    void insertFilm(Film film);

    List<Film> getTopRecommendedItemCF(int userId, int howMuch);

    void deleteFilm(int filmID);

    void addComment(Comment comment);

    List<Comment> getAllCommentsByFilmId(int filmId);

}