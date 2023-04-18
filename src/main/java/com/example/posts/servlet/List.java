package com.example.posts.servlet;

import com.example.posts.model.Post;
import com.example.posts.service.PostService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/list"})
public class List extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostService postService = new PostService();
        java.util.List<Post> postList = postService.fetchAllPosts();


        req.setAttribute("list",postList);
        req
                .getRequestDispatcher("/WEB-INF/list-post.jsp")
                .forward(req, resp);
    }
}
