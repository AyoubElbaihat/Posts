package com.example.posts.servlet;

import com.example.posts.model.Category;
import com.example.posts.model.Post;
import com.example.posts.service.CategoryService;
import com.example.posts.service.PostService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/list-category"})
public class ListCategoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryService categoryService = new CategoryService();

        java.util.List<Category> categoryList = categoryService.fetchAllCategory();


        req.setAttribute("category",categoryList);
        req
                .getRequestDispatcher("/WEB-INF/list-category.jsp")
                .forward(req, resp);
    }
}
