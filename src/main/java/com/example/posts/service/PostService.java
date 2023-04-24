package com.example.posts.service;

import com.example.posts.Dao.PostJdbcDao;
import com.example.posts.model.Post;
import com.github.javafaker.Faker;

import java.time.LocalDateTime;
import java.util.*;

// CRUD
public class PostService {
    PostJdbcDao postJdbcDao = new PostJdbcDao();
    private static Faker faker = new Faker(new Locale("fr"));

    private static long idSequence = 0;



    public List<Post> fetchAllPosts() {
        return postJdbcDao.findAll();
    }



    public Post createPost(String title, String author, String content,String pictureUrl) {
        PostJdbcDao postJdbcDao = new PostJdbcDao();
        LocalDateTime time = LocalDateTime.now();
        Post p = new Post( title, author, content, pictureUrl,time);

        postJdbcDao.create(p);
        return p;
    }
    public Post updatePost(Integer id, String title, String author, String content, String pictureUrl) {
        PostJdbcDao postJdbcDao = new PostJdbcDao();
        LocalDateTime time = LocalDateTime.now();
        Post p = new Post( id, title, author, content, pictureUrl);

        postJdbcDao.update(p);
        return p;
    }



}
