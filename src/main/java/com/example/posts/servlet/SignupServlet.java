package com.example.posts.servlet;


import com.example.posts.Dao.UserDao;
import com.example.posts.Dao.UserJdbcDao;
import com.example.posts.exception.UserAlreadyExistException;
import com.example.posts.model.User;

import com.example.posts.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/signup")
public class SignupServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/signup.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");
        String email = req.getParameter("username");

        boolean isInvalid = password.isBlank() || email.isBlank();

        if (isInvalid) {
            req.setAttribute("isError1", true);
        } else {
            try {
                UserService userService = new UserService();
                userService.register(email, password);


            } catch (UserAlreadyExistException e) {
                req.setAttribute("isError", true);
            } catch (Exception e) {
                req.setAttribute("isError1", true);
            }
        }
        req.setAttribute("username", email);
        req.getRequestDispatcher("/WEB-INF/signup.jsp").forward(req, resp);
    }
}

