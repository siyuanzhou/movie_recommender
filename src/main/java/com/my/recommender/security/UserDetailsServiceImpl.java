package com.my.recommender.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.my.recommender.dao.UserDao;
import com.my.recommender.model.UserAuth;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        UserAuth userAuth = userDao.getUserAuth(name);
        if (userAuth == null)
            throw new UsernameNotFoundException("No user with username " + name);
        return userAuth;
    }

}
