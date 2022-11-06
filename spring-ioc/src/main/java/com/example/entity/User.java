package com.example.entity;

public class User {
    private String id;
    private String username;

    public User() {
        System.out.println("user is ready");
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
