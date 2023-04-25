package com.example.posts.Dao;

import com.example.posts.model.Category;
import com.example.posts.model.Post;
import com.example.posts.model.User;


import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

public class PostJdbcDao implements PostDao{
    @Override
    public Post create(Post entity) {
        Connection connection = ConnectionManager.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO posts(title,author,content,pictureUrl,createdAt,idCategory) VALUES (?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, entity.getTitle());
            preparedStatement.setString(2, entity.getAuthor());
            preparedStatement.setString(3, entity.getContent());
            preparedStatement.setString(4, entity.getPictureUrl());
            preparedStatement.setDate(5, new java.sql.Date(System.currentTimeMillis()));
            preparedStatement.setInt(6, entity.getCategory().getId());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 1) {
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    entity.setId(generatedKeys.getInt(1));
                    return entity;
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return null;
    }


    @Override
    public  List<Post> findAll() {
        List<Post> postList = new ArrayList<>();
        Connection connection = ConnectionManager.getInstance();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT p.id,p.title,p.author,p.content,p.pictureUrl,p.createdAt,c.nameCategory FROM posts p JOIN categorys c ON p.idCategory = c.id");
            while (resultSet.next()){
                Integer id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String content = resultSet.getString("content");
                String pictureUrl = resultSet.getString("pictureUrl");
                String nameCategory = resultSet.getString("nameCategory");

                Timestamp createdAtTimestamp = resultSet.getTimestamp("createdAt");
                LocalDateTime createdAt = createdAtTimestamp != null ? createdAtTimestamp.toLocalDateTime() : null;
                CategoryJdbcDao categoryJdbcDao = new CategoryJdbcDao();
                Category category =categoryJdbcDao.findByName(nameCategory);
                postList.add(new Post(id, title, author,content,pictureUrl,createdAt,category));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return postList;
    }
    public  List<Post> findByCat(String string) {
        List<Post> postList = new ArrayList<>();
        Connection connection = ConnectionManager.getInstance();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT p.id, p.title,p.author,p.content,p.pictureUrl,p.createdAt,c.nameCategory FROM posts p JOIN categorys c ON p.idCategory = c.id WHERE c.nameCategory=?");
            statement.setString(1, string);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Integer id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String content = resultSet.getString("content");
                String pictureUrl = resultSet.getString("pictureUrl");
                String nameCategory = resultSet.getString("nameCategory");

                Timestamp createdAtTimestamp = resultSet.getTimestamp("createdAt");
                LocalDateTime createdAt = createdAtTimestamp != null ? createdAtTimestamp.toLocalDateTime() : null;
                CategoryJdbcDao categoryJdbcDao = new CategoryJdbcDao();
                Category category =categoryJdbcDao.findByName(nameCategory);
                postList.add(new Post(id, title, author,content,pictureUrl,createdAt,category));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return postList;
    }

    @Override

    public Post findById(Integer integer) {

        Post postFound = null;

        Connection connection = ConnectionManager.getInstance();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT p.id, p.title,p.author,p.content,p.pictureUrl,p.createdAt,c.nameCategory FROM posts p JOIN categorys c ON p.idCategory = c.id WHERE p.id=?");
            statement.setInt(1, integer);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String content = resultSet.getString("content");
                String pictureUrl = resultSet.getString("pictureUrl");
                Timestamp createdAtTimestamp = resultSet.getTimestamp("createdAt");
                LocalDateTime createdAt = createdAtTimestamp != null ? createdAtTimestamp.toLocalDateTime() : null;
                String nameCategory = resultSet.getString("nameCategory");
                CategoryJdbcDao categoryJdbcDao = new CategoryJdbcDao();
                Category category =categoryJdbcDao.findByName(nameCategory);
                postFound = new Post(id,title, author,content,pictureUrl,createdAt,category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postFound;
    }

    @Override
    public void update(Post entity) {
        Connection connection = ConnectionManager.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE posts SET title=?, author=?, content=?, pictureUrl=?,idCategory=? WHERE id=?");
            preparedStatement.setString(1, entity.getTitle());
            preparedStatement.setString(2, entity.getAuthor());
            preparedStatement.setString(3, entity.getContent());
            preparedStatement.setString(4, entity.getPictureUrl());
//            preparedStatement.setDate(5, new java.sql.Date(entity.getCreatedAt().toInstant(ZoneOffset.UTC).toEpochMilli()));
//            preparedStatement.setDate(5, new java.sql.Date(entity.getCreatedAt().toInstant(ZoneOffset.UTC).toEpochMilli()));
            preparedStatement.setInt(5, entity.getCategory().getId());
            preparedStatement.setInt(6, entity.getId());
            preparedStatement.executeUpdate();
            System.out.println("done");
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
