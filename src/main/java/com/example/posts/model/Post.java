package com.example.posts.model;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class Post {

    private Integer id;
    private String title;
    private String author;
    private String content;
    private String pictureUrl;
    private LocalDateTime createdAt;
    private Category category;

    public Post() {
    }

    public Post(Integer id) {
        this.id = id;
    }

    public Post(Integer id, String title, String author, String content,Category category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.category = category;

    }

    public Post(Integer id, String title, String author, String content, String pictureUrl, LocalDateTime createdAt,Category category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.pictureUrl = pictureUrl;
        this.createdAt = createdAt;
        this.category = category;
    }

    public Post(Integer id, String title, String author, String content, String pictureUrl,Category category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.pictureUrl = pictureUrl;
        this.category = category;
    }

    public Post(String title, String author, String content, String pictureUrl, LocalDateTime createdAt,Category category) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.pictureUrl = pictureUrl;
        this.createdAt = createdAt;
        this.category = category;
    }

    public Integer getId() {
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
