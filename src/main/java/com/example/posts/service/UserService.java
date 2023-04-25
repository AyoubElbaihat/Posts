package com.example.posts.service;

import com.example.posts.Dao.UserDao;
import com.example.posts.Dao.UserJdbcDao;
import com.example.posts.exception.UserAlreadyExistException;
import com.example.posts.model.User;

import java.sql.Connection;

public class UserService {
    private UserDao userJdbcDao = new UserJdbcDao();

    public void register(String email, String password) throws Exception {
        User user = userJdbcDao.findByUseremail(email);
        if (user != null) {
            throw new UserAlreadyExistException(email);
        } else {
            User newUser = new User(email, password);
//            if (!userJdbcDao.create(newUser)) {
//                throw new Exception("Cannot register user");
//            }

        }


    }
}
