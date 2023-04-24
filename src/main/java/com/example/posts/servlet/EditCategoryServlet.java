package com.example.posts.servlet;

import com.example.posts.Dao.CategoryJdbcDao;
import com.example.posts.Dao.PostJdbcDao;
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

@WebServlet(urlPatterns = "/edit-category")
public class EditCategoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryJdbcDao categoryJdbcDao = new CategoryJdbcDao();
        List<Category> categoryList = categoryJdbcDao.findAll();
        int id = Integer.parseInt(req.getParameter("id"));
        Category category = categoryJdbcDao.findById(id);
        req.setAttribute("id",id);
        req.setAttribute("nameCategory",category.getNameCategory());
        req.setAttribute("categorys",categoryList);
        req
                .getRequestDispatcher("/WEB-INF/edit-category-form.jsp")
                .forward(req, resp);





    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = Integer.parseInt(req.getParameter("id"));
        String nameCategory = req.getParameter("nameCategory");
//        CategoryJdbcDao categoryJdbcDao = new CategoryJdbcDao();
//        Category category = new Category(id,nameCategory);
//        categoryJdbcDao.update(category);
        CategoryService categoryService = new CategoryService();
        categoryService.updateCategory(id,nameCategory);
        resp.sendRedirect("/categorys");


    }
}
