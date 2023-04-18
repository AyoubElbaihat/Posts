package com.example.posts.exception;

public class UserAlreadyExistException extends Exception {

    public UserAlreadyExistException(String email) {
        super("user with email " + email + " already exist");
    }
}
