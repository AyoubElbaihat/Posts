//package com.example.posts.servlet;
//
//
//import com.example.posts.Dao.ConnectionManager;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//@WebServlet(urlPatterns = "/login")
//public class LoginServlet extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//
//        try{
//            ConnectionManager.getInstance();
//            Statement stmt= ConnectionManager.getInstance().createStatement();
//            ResultSet rs=stmt.executeQuery("select * from postproject.users");
//            if (rs.next()){
//                String dbemail = rs.getString(2);
//                String dbpassword = rs.getString(3);
//                if (username.equals(dbemail) && password.equals(dbpassword)){
//                    System.out.println("ok2");
//                    HttpSession session = req.getSession();
//                    session.setAttribute("username", dbemail);
//                    resp.sendRedirect(req.getContextPath() + "/posts");
//                    return;
//                }else {
//                    req.setAttribute("isError", true);
//
//                    req
//                            .getRequestDispatcher("/WEB-INF/login.jsp")
//                            .forward(req, resp);
//                }
//            }
//
//
////            ConnectionManager.closeConnection();
//
//        }
//        catch(Exception e){
//            System.out.println(e);
//        }
//
//
//    }
//}
package com.example.posts.servlet;

import com.example.posts.Dao.UserDao;
import com.example.posts.Dao.UserJdbcDao;
import com.example.posts.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserDao userDao = new UserJdbcDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("username");
        String password = req.getParameter("password");
        User user = userDao.findByUseremail(email);

        if (user != null && user.getPassword().equals(password)) {
            System.out.println("1");
            HttpSession session = req.getSession(true);
            session.setAttribute("username", user);
            resp.sendRedirect("/posts");
        } else {
            req.setAttribute("isError", true);
            req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
        }
    }
}
