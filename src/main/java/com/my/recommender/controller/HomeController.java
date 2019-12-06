package com.my.recommender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.my.recommender.service.FilmService;

@Controller
public class HomeController {

    @Autowired
    private FilmService filmService;

    @GetMapping({ "", "/", "home" })
    public String mainPage() {
        return "home";
    }

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @GetMapping("logout")
    public String logout() {
        return "logout";
    }

    @GetMapping("registration")
    public String registration() {
        return "registration";
    }

    @GetMapping("admin")
    public String admin(Model model) {
        model.addAttribute("films", filmService.getAllFilmsWithAvgRating());
        return "allFilms";
    }

    @GetMapping("user")
    public String user(Model model) {
        model.addAttribute("films", filmService.getAllFilmsWithAvgRating());
        return "allFilms";
    }
}