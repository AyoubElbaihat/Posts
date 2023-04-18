package com.example.posts.Dao;

import com.example.posts.model.Post;


import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

public class PostJdbcDao implements PostDao{
    @Override
    public boolean create(Post entity) {
        Connection connection = ConnectionManager.getInstance();
        boolean insertOK = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO posts(title,author,content,pictureUrl,createdAt) VALUES (?,?,?,?,?)");

            preparedStatement.setString(1, entity.getTitle());
            preparedStatement.setString(2, entity.getAuthor());
            preparedStatement.setString(3, entity.getContent());
            preparedStatement.setString(4, entity.getPictureUrl());
            preparedStatement.setDate(5, new java.sql.Date(System.currentTimeMillis()));
            int rowsAffected = preparedStatement.executeUpdate();
            insertOK = rowsAffected > 0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return insertOK;
    }

    @Override
    public  List<Post> findAll() {
        List<Post> postList = new ArrayList<>();
        Connection connection = ConnectionManager.getInstance();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id,title,author,content,pictureUrl,createdAt FROM posts");
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String content = resultSet.getString("content");
                String pictureUrl = resultSet.getString("pictureUrl");

                LocalDateTime createdAt = resultSet.getTimestamp("createdAt").toLocalDateTime();
                postList.add(new Post(id, title, author,content,pictureUrl,createdAt));
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
        Connection connection = ConnectionManager.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE posts SET title=?, author=?, content=?, pictureUrl=?, createdAt=? WHERE id=?");
            preparedStatement.setString(1, entity.getTitle());
            preparedStatement.setString(2, entity.getAuthor());
            preparedStatement.setString(3, entity.getContent());
            preparedStatement.setString(4, entity.getPictureUrl());
            preparedStatement.setDate(5, new java.sql.Date(entity.getCreatedAt().toInstant(ZoneOffset.UTC).toEpochMilli()));
            preparedStatement.setLong(6, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Post entity) {
        Connection connection = ConnectionManager.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM posts WHERE id=?");
            preparedStatement.setLong(1, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
