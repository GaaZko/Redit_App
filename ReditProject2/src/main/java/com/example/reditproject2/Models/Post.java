package com.example.reditproject2.Models;

import javax.persistence.*;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nameOfPost;

    Integer likes = 0;
    Integer disLikes = 0;
    String url;

    Integer counAllLikesAndDislikes = 0;
    @ManyToOne
    @JoinColumn(name = "id_User")
    User user;

    public Post() {
    }

    public Post(String nameOfPost, Integer likes, Integer disLikes, String url) {
        this.nameOfPost = nameOfPost;
        this.likes = likes;
        this.disLikes = disLikes;
        this.url = url;
    }

    public Post(String nameOfPost, String url) {
        this.nameOfPost = nameOfPost;
        this.url = url;

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNameOfPost() {
        return nameOfPost;
    }

    public Integer getCounAllLikesAndDislikes() {
        return counAllLikesAndDislikes;
    }

    public void setCounAllLikesAndDislikes(Integer counAllLikesAndDislikes) {
        this.counAllLikesAndDislikes = counAllLikesAndDislikes;
    }

    public void setNameOfPost(String nameOfPost) {
        this.nameOfPost = nameOfPost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getDisLikes() {
        return disLikes;
    }

    public void setDisLikes(Integer disLikes) {
        this.disLikes = disLikes;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
