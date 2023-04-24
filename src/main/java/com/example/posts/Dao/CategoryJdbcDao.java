package com.example.posts.Dao;

import com.example.posts.model.Category;
import com.example.posts.model.Post;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CategoryJdbcDao implements CategoryDao{
    @Override
    public boolean create(Category entity) {
        Connection connection = ConnectionManager.getInstance();
        boolean insertOK = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO categorys(nameCategory) VALUES (?)");

            preparedStatement.setString(1, entity.getNameCategory());

            int rowsAffected = preparedStatement.executeUpdate();
            insertOK = rowsAffected > 0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return insertOK;
    }

    @Override
    public  List<Category> findAll() {
        List<Category> categoryList = new ArrayList<>();
        Connection connection = ConnectionManager.getInstance();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id,nameCategory FROM categorys");
            while (resultSet.next()){
                Integer id = resultSet.getInt("id");
                String nameCategory = resultSet.getString("nameCategory");
                categoryList.add(new Category(id, nameCategory));
        }
        return categoryList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


        @Override

    public Category findById(Integer integer) {

        Category categoryFound = null;

        Connection connection = ConnectionManager.getInstance();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT id, nameCategory FROM categorys WHERE id=?");
            statement.setInt(1, integer);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nameCategory = resultSet.getString("nameCategory");

                categoryFound = new Category(id,nameCategory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryFound;
    }

    @Override
    public void update(Category entity) {
        Connection connection = ConnectionManager.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE categorys SET nameCategory=?WHERE id=?");
            preparedStatement.setString(1, entity.getNameCategory());
            preparedStatement.setInt(2, entity.getId());
            preparedStatement.executeUpdate();
            System.out.println("done");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Category entity) {
        Connection connection = ConnectionManager.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM categorys WHERE id=?");
            preparedStatement.setLong(1, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
