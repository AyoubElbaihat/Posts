package com.example.posts.resource;

import com.example.posts.Dao.ConnectionManager;
import com.example.posts.Dao.PostJdbcDao;
import com.example.posts.model.Post;
import com.example.posts.service.PostService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@Path("posts")
public class PostResource {
    PostJdbcDao postJdbcDao = new PostJdbcDao();
    @GET

    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Post> findAll(){
        return postJdbcDao.findAll();
    }
    @GET
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Post getPostById(@PathParam("id") int id){
      return postJdbcDao.findById(id);
    }
    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Response creatPost(Post post){
        postJdbcDao.create(post);
        return Response
                .status(Response.Status.CREATED)
                .entity(post)
                .build();
    }
    @DELETE
    @Path("/delete/{id}")
    public void delete(@PathParam("id") int id) {
        Post postToDelete = postJdbcDao.findById(id);
        postJdbcDao.delete(postToDelete);
    }
    @PUT
    @Path("/edit/{id}")
    public Post update(@PathParam("id") int id,Post newPost) {
        postJdbcDao.create(newPost);
        Post postToUpdate = postJdbcDao.findById(id);
        newPost.setId(postToUpdate.getId());
        postJdbcDao.update(newPost);
        return newPost;
    }
}
