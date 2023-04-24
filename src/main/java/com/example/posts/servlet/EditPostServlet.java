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
import java.util.List;

@WebServlet(urlPatterns = "/edit")
public class EditPostServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostJdbcDao postJdbcDao = new PostJdbcDao();
        List<Post> postList = postJdbcDao.findAll();
        int id = Integer.parseInt(req.getParameter("id"));
        Post post = postJdbcDao.findById(id);
        req.setAttribute("id",id);
        req.setAttribute("title",post.getTitle());
        req.setAttribute("author",post.getAuthor());
        req.setAttribute("content",post.getContent());
        req.setAttribute("pictureUrl",post.getContent());
        req.setAttribute("posts",postList);
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
        String pictureUrl = req.getParameter("pictureUrl");
        PostService postService = new PostService();
        postService.updatePost(id ,title, author, content,pictureUrl);
        resp.sendRedirect("/posts");


    }
}
