package com.example.posts.Dao;

import com.example.posts.model.User;

public interface UserDao extends GenericDao<User, Integer>{
    User findByUseremail(String email);
}
