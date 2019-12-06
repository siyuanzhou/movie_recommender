package com.my.recommender.controller.restApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.my.recommender.model.User;
import com.my.recommender.service.UserService;

@RestController
public class UserRestController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "createUser", method = RequestMethod.POST, produces = "application/json")
    public User createUser(@RequestBody User jUser) {
        User user = new User();
        user.setName(jUser.getName());
        user.setPassword(jUser.getPassword());
        userService.insertUser(user);
        System.out.println("new user added");
        return user;
    }

}
