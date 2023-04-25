package com.example.posts.service;

import com.example.posts.Dao.CategoryJdbcDao;
import com.example.posts.Dao.PostJdbcDao;
import com.example.posts.model.Category;
import com.example.posts.model.Post;
import com.github.javafaker.Faker;

import java.time.LocalDateTime;
import java.util.*;

// CRUD
public class PostService {
    PostJdbcDao postJdbcDao = new PostJdbcDao();
    public List<Post> fetchAllPosts() {
        return postJdbcDao.findAll();
    }
    public Post findById(int id){
        return postJdbcDao.findById(id);
    }

    public Post createPost(String title, String author, String content,String pictureUrl,Integer idCategory) {
        LocalDateTime time = LocalDateTime.now();
        CategoryJdbcDao categoryJdbcDao = new CategoryJdbcDao();
        Category category = categoryJdbcDao.findById(idCategory);
        Post p = new Post( title, author, content, pictureUrl,time,category);
        return postJdbcDao.create(p);
    }
    public void deletePost(Post post){
        postJdbcDao.delete(post);
    }
    public Post updatePost2(Post post){

        postJdbcDao.update(post);
        return post;
    }
    public Post updatePost(Integer id, String title, String author, String content, String pictureUrl,Integer idCategory) {
        PostJdbcDao postJdbcDao = new PostJdbcDao();
//        LocalDateTime time = LocalDateTime.now();
        CategoryJdbcDao categoryJdbcDao = new CategoryJdbcDao();
        Category category = categoryJdbcDao.findById(idCategory);
        Post p = new Post( id, title, author, content, pictureUrl,category);
        postJdbcDao.update(p);
        return p;
    }



}
