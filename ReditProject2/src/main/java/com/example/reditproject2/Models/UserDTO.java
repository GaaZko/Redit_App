package com.example.reditproject2.Models;

import java.util.List;

public class UserDTO {
    String name;
    List<PostPost> posts;

    public UserDTO() {
    }

    public UserDTO(String name, List<PostPost> posts) {
        this.name = name;
        this.posts = posts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PostPost> getPosts() {
        return posts;
    }

    public void setPosts(List<PostPost> posts) {
        this.posts = posts;
    }
}
