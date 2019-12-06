package com.my.recommender.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HTTPErrorHandler {

    @RequestMapping(value = "/404")
    public String error404() {
        return "/404";
    }

    @RequestMapping(value = "/403")
    public String error403() {
        return "/403";
    }

}