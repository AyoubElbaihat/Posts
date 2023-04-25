package com.example.posts.service;

import com.example.posts.Dao.CategoryJdbcDao;
import com.example.posts.Dao.PostJdbcDao;
import com.example.posts.model.Category;
import com.example.posts.model.Post;
import com.github.javafaker.Faker;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

// CRUD
public class CategoryService {
    CategoryJdbcDao categoryJdbcDao = new CategoryJdbcDao();
    public List<Category> fetchAllCategory() {

        return categoryJdbcDao.findAll();
    }

    public Category findById(int id){
        return categoryJdbcDao.findById(id);
    }

    public Category createCategory(String nameCategory) {
        Category c = new Category( nameCategory);
        return categoryJdbcDao.create(c);
    }
    public void deleteCategory(Category category){
        categoryJdbcDao.delete(category);
    }
    public Category updateCategory(Integer id, String nameCategory) {
        Category c = new Category( id, nameCategory);

        categoryJdbcDao.update(c);
        return c;
    }
    public Category updateCategory2(Category category){

        categoryJdbcDao.update(category);
        return category;
    }



}
