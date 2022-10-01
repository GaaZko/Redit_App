package com.example.reditproject2.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nameOfUser;
    String passwordOfUser;
    @OneToMany(mappedBy = "user")
    List<Post> posts;

    public User() {
    }

    public User(String nameOfUser, String passwordOfUser) {
        this.nameOfUser = nameOfUser;
        this.passwordOfUser = passwordOfUser;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfUser() {
        return nameOfUser;
    }

    public void setNameOfUser(String nameOfUser) {
        this.nameOfUser = nameOfUser;
    }

    public String getPasswordOfUser() {
        return passwordOfUser;
    }

    public void setPasswordOfUser(String passwordOfUser) {
        this.passwordOfUser = passwordOfUser;
    }
}
