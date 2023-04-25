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
    PostService postService = new PostService();
    @GET

    @Produces(value = MediaType.APPLICATION_JSON)
    public Response findAll(){
        List<Post> postList = postService.fetchAllPosts();
        return Response.ok(postList).build();
    }
    @GET
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response getPostById(@PathParam("id") int id){
      Post foundedPost =postService.findById(id);
      return Response.ok(foundedPost).build();
    }

    @POST
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Response creatPost(Post post){
        Post postCreated = postService.createPost(post.getTitle(), post.getAuthor(), post.getContent(),
                post.getPictureUrl(), post.getCategory().getId());
        return Response
                .status(Response.Status.CREATED)
                .entity(postCreated)
                .build();
    }
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {

        Post postToDelete = postService.findById(id);
        if(postToDelete == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        postService.deletePost(postToDelete);
        return Response.noContent().build();
    }
    @PUT
    @Path("/{id}")
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id,Post post) {
        Post updetedPost = postService.updatePost2(post);
        return Response.ok(updetedPost).build();
    }
}
