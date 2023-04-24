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
import java.util.List;

@WebServlet(urlPatterns = { "/categorys"})
public class CategoryListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryService categoryService = new CategoryService();
        List<Category> categoryList = categoryService.fetchAllCategory();


        req.setAttribute("categorys", categoryList);
        req
                .getRequestDispatcher("/WEB-INF/category-list.jsp")
                .forward(req, resp);
    }
}
