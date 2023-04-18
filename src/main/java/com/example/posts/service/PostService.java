package com.example.posts.service;

import com.example.posts.Dao.PostJdbcDao;
import com.example.posts.model.Post;
import com.github.javafaker.Faker;

import java.time.LocalDateTime;
import java.util.*;

// CRUD
public class PostService {
    PostJdbcDao postJdbcDao = new PostJdbcDao();
    private static Faker faker = new Faker(new Locale("fr"));

    private static long idSequence = 0;

//    private static List<Post> posts = new ArrayList<>(Arrays.asList(
//            new Post(++idSequence, faker.book().title(), faker.book().author(), faker.lorem().characters(20), "https://picsum.photos/200/300?random=1"),
//            new Post(++idSequence, faker.book().title(), faker.book().author(), faker.lorem().characters(20), "https://picsum.photos/200/300?random=2"),
//            new Post(++idSequence, faker.book().title(), faker.book().author(), faker.lorem().characters(20), "https://picsum.photos/200/300?random=3"),
//            new Post(++idSequence, faker.book().title(), faker.book().author(), faker.lorem().characters(20), "https://picsum.photos/200/300?random=4")
//    ));
    private static List<Post> posts = new ArrayList<>();

    public List<Post> fetchAllPosts() {
        return postJdbcDao.findAll();
    }



    public Post createPost(String title, String author, String content) {
        PostJdbcDao postJdbcDao = new PostJdbcDao();
//        LocalDateTime time = LocalDateTime.now();
        Post p = new Post(++idSequence, title, author, content, "https://picsum.photos/200/300?random=" + idSequence);
        posts.add(p);
        postJdbcDao.create(p);
        return p;
    }


}
