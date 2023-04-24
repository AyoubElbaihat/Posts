package com.example.posts.servlet;

import com.example.posts.Dao.CategoryJdbcDao;
import com.example.posts.Dao.PostJdbcDao;
import com.example.posts.model.Category;
import com.example.posts.model.Post;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(urlPatterns = "/delete-category")
public class DeleteCategoryServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            CategoryJdbcDao categoryJdbcDao = new CategoryJdbcDao();
            Integer categoryId = Integer.parseInt(req.getParameter("id"));
            Category categoryToDelete = categoryJdbcDao.findById(categoryId);
            categoryJdbcDao.delete(categoryToDelete);
            resp.sendRedirect("list-category");
        }
}
