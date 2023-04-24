package com.example.posts.servlet;

import com.example.posts.Dao.PostJdbcDao;
import com.example.posts.service.PostService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/edit-category")
public class EditCategoryServlet extends HttpServlet {
    PostJdbcDao postJdbcDao = new PostJdbcDao();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req
                .getRequestDispatcher("/WEB-INF/edit-post-form.jsp")
                .forward(req, resp);





    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String content = req.getParameter("content");
        PostService postService = new PostService();
        postService.updatePost(id ,title, author, content);
        resp.sendRedirect("posts");


    }
}
