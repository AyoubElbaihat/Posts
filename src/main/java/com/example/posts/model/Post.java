package com.example.posts.model;

import java.time.LocalDateTime;

public class Post {

    private Long id;
    private String title;
    private String author;
    private String content;
    private String pictureUrl;
    private LocalDateTime createdAt;

    public Post(Long id, String title, String author, String content, String pictureUrl) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.pictureUrl = pictureUrl;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }
}
