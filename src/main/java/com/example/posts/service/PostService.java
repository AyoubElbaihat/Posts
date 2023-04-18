package com.example.posts.service;

import com.example.posts.model.Post;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

// CRUD
public class PostService {

    private static Faker faker = new Faker(new Locale("fr"));

    private static long idSequence = 0;

    private static List<Post> posts = new ArrayList<>(Arrays.asList(
            new Post(++idSequence, faker.book().title(), faker.book().author(), faker.lorem().characters(20), "https://picsum.photos/200/300?random=1"),
            new Post(++idSequence, faker.book().title(), faker.book().author(), faker.lorem().characters(20), "https://picsum.photos/200/300?random=2"),
            new Post(++idSequence, faker.book().title(), faker.book().author(), faker.lorem().characters(20), "https://picsum.photos/200/300?random=3"),
            new Post(++idSequence, faker.book().title(), faker.book().author(), faker.lorem().characters(20), "https://picsum.photos/200/300?random=4")
    ));

    public List<Post> fetchAllPosts() {
        return this.posts;
    }

    public Post createPost(String title, String author, String content) {
        Post p = new Post(++idSequence, title, author, content, "https://picsum.photos/200/300?random=" + idSequence);
        posts.add(p);
        return p;
    }


}
