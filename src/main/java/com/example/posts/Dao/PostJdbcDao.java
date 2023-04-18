package com.example.posts.Dao;

import com.example.posts.model.Post;


import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostJdbcDao implements PostDao{
    @Override
    public boolean create(Post entity) {
        Connection connection = ConnectionManager.getInstance();
        boolean insertOK = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO posts(id,title,author,content,pictureUrl) VALUES (?,?,?,?,?)");
            preparedStatement.setLong(1,entity.getId());
            preparedStatement.setString(2, entity.getTitle());
            preparedStatement.setString(3, entity.getAuthor());
            preparedStatement.setString(4, entity.getContent());
            preparedStatement.setString(5, entity.getPictureUrl());
            int rowsAffected = preparedStatement.executeUpdate();
            insertOK = rowsAffected > 0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return insertOK;
    }

    @Override
    public List<Post> findAll() {
        List<Post> postList = new ArrayList<>();
        Connection connection = ConnectionManager.getInstance();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id,title,author,content,pictureUrl FROM posts");
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String content = resultSet.getString("content");
                String pictureUrl = resultSet.getString("pictureUrl");
//                LocalDateTime createdAt = resultSet.getDate("createdAt");
                postList.add(new Post(id, title, author,content,pictureUrl));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return postList;
    }

    @Override
    public Post findById(Long integer) {
        return null;
    }

    @Override
    public void update(Post entity) {

    }

    @Override
    public void delete(Post entity) {

    }
}
