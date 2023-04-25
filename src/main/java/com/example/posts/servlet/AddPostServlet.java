package com.example.posts.servlet;

import com.example.posts.model.Category;
import com.example.posts.service.CategoryService;
import com.example.posts.service.PostService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/add-post")
public class AddPostServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList = new CategoryService().fetchAllCategory();
        request.setAttribute("categorys", categoryList);
        request
                .getRequestDispatcher("/WEB-INF/add-post-form.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String content = req.getParameter("content");
        String pictureUrl = req.getParameter("pictureUrl");
        int idCategory = Integer.parseInt(req.getParameter("idCategory"));


        PostService postService = new PostService();
        postService.createPost(title, author, content,pictureUrl,idCategory);
        resp.sendRedirect("/posts");

    }
}
