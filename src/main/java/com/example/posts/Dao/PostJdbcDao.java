package com.example.posts.Dao;

import com.example.posts.model.Post;

import java.util.List;

public class PostJdbcDao implements PostDao{
    @Override
    public boolean create(Post entity) {
        return false;
    }

    @Override
    public List<Post> findAll() {
        return null;
    }

    @Override
    public Post findById(Integer integer) {
        return null;
    }

    @Override
    public void update(Post entity) {

    }

    @Override
    public void delete(Post entity) {

    }
}
