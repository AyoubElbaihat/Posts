package com.example.posts.servlet;

import com.example.posts.Dao.PostJdbcDao;

import com.example.posts.model.Post;
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
            PostJdbcDao postJdbcDao = new PostJdbcDao();
            Long postId = Long.parseLong(req.getParameter("id"));
            Post postToDelete = new Post(postId);
            postJdbcDao.delete(postToDelete);
            resp.sendRedirect("list");
        }

}
