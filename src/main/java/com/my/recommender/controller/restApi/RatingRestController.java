package com.my.recommender.controller.restApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.my.recommender.model.Rating;
import com.my.recommender.service.RatingService;

@RestController
public class RatingRestController {

    @Autowired
    RatingService ratingService;

    @RequestMapping(value = "rateFilm", method = RequestMethod.POST, produces = "application/json")
    public Rating insertRating(@RequestBody Rating jRating, @SessionAttribute int id) {
        jRating.setUserId(id);
        System.out.println(jRating.toString());
        ratingService.insertRating(jRating);
        return jRating;
    }

}
