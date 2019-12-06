package com.my.recommender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.my.recommender.model.Comment;
import com.my.recommender.model.Film;
import com.my.recommender.service.FilmService;
import com.my.recommender.service.RecommenderService;

@Controller
@SessionAttributes("id")
public class FilmController {

    @Autowired
    FilmService filmService;

    @Autowired
    RecommenderService recommenderService;

    @GetMapping("user/allFilms")
    public String allFilms(Model model) {
        model.addAttribute("films", filmService.getAllFilmsWithAvgRating());
        return "allFilms";
    }

    @GetMapping("admin/addFilm")
    public String addFilm(Model model) {
        return "addFilm";
    }

    @RequestMapping(value = "admin/insertFilm", method = RequestMethod.POST)
    public String filmAdd(String title, String year, String post, String description) {
        Film film = new Film();
        film.setTitle(title);
        film.setYear(year);
        film.setPoster(post);
        film.setDescription(description);
        filmService.insertFilm(film);
        return "success";
    }

    @RequestMapping(value = "user/film/addComment/{filmId}", method = RequestMethod.POST)
    public String commentAdd(@PathVariable("filmId") int filmId, @SessionAttribute int id, String content) {
        Comment comment = new Comment();
        comment.setIdFilm(filmId);
        comment.setIdUser(id);
        comment.setContent(content);
        filmService.addComment(comment);
        return "redirect:/user/film/" + filmId;
    }

    @GetMapping("user/film/{filmId}")
    public String filmInfo(Model model, @PathVariable("filmId") int filmId, @SessionAttribute int id) {
        model.addAttribute("film", filmService.getFilmByIdWithAvgRatingAndUserRating(id, filmId));
        model.addAttribute("prediction", recommenderService.getPrediction(id, filmId));
        model.addAttribute("comments", filmService.getAllCommentsByFilmId(filmId));
        return "film";
    }

    @GetMapping(value = "user/film/deleteFilm/{filmId}")
    public String insertRating(@PathVariable("filmId") int filmId) {
        filmService.deleteFilm(filmId);
        return "deletesuccess";
    }
}
