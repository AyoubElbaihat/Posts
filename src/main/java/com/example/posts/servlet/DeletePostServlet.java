package com.example.posts.servlet;

import com.example.posts.Dao.PostJdbcDao;

import com.example.posts.model.Post;
import com.example.posts.service.PostService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(urlPatterns = "/delete")
public class DeletePostServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            PostService postService = new PostService();
            Integer postId = Integer.parseInt(req.getParameter("id"));
            Post postToDelete = new Post(postId);
            postService.deletePost(postToDelete);
            resp.sendRedirect("list-post");
        }

}
