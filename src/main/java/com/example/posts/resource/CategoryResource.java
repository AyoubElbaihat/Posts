package com.example.posts.resource;

import com.example.posts.Dao.CategoryJdbcDao;
import com.example.posts.Dao.PostJdbcDao;
import com.example.posts.model.Category;
import com.example.posts.model.Post;
import com.example.posts.service.CategoryService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("categories")
public class CategoryResource {
    CategoryService categoryService = new CategoryService();

    @GET

    @Produces(value = MediaType.APPLICATION_JSON)
    public Response findAll(){
        List<Category> categoryList = categoryService.fetchAllCategory();
        return Response.ok(categoryList).build();
    }

    @GET
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response getPostById(@PathParam("id") int id){
        Category foundedCategory =categoryService.findById(id);
        return Response.ok(foundedCategory).build();
    }
    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Response creatPost(Category category){
        Category categoryCreated = categoryService.createCategory(category.getNameCategory());
        return Response
                .status(Response.Status.CREATED)
                .entity(categoryCreated)
                .build();
    }
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {

        Category categoryToDelete = categoryService.findById(id);
        if(categoryToDelete == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        categoryService.deleteCategory(categoryToDelete);
        return Response.noContent().build();
    }
    @PUT
    @Path("/{id}")
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id,Category category) {
        Category updetedCategory = categoryService.updateCategory2(category);
        return Response.ok(updetedCategory).build();
    }
}
