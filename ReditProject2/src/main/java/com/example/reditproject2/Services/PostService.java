package com.example.reditproject2.Services;

import com.example.reditproject2.Models.Post;
import com.example.reditproject2.Models.PostPost;
import com.example.reditproject2.Repositories.PostRepository;
import com.example.reditproject2.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    final PostRepository postRepository;
    final UserRepository userRepository;
    @Autowired

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public List<Post> getAllPosts (){
       return postRepository.findAll();
    }

    public void addNewPost(String title, String url,Long id) {
        Post newPost = new Post();
        newPost.setNameOfPost(title);
        newPost.setUrl(url);
        newPost.setUser(userRepository.findById(id).get());
        postRepository.save(newPost);
    }

    public void addLike (Long id){
        Post newPost = postRepository.findById(id).get();
        newPost.setLikes(newPost.getLikes() + 1);
        postRepository.save(newPost);
        counAllLikesAndDislikes(newPost);
    }

    public void addDislike (Long id){
        Post newPost = postRepository.findById(id).get();
        newPost.setDisLikes(newPost.getDisLikes() + 1);
        postRepository.save(newPost);
        counAllLikesAndDislikes(newPost);
    }
    public void counAllLikesAndDislikes (Post post) {
        Integer count = post.getLikes() - post.getDisLikes();
        post.setCounAllLikesAndDislikes(count);
        postRepository.save(post);
    }

    public PostPost addNewPost(PostPost postPost) {
        Post newPost = new Post();
        newPost.setNameOfPost(postPost.getName());
        newPost.setUrl(postPost.getUrl());
        postRepository.save(newPost);
        PostPost newPostPost = new PostPost();
        newPostPost.setName(newPost.getNameOfPost());
        newPostPost.setUrl(newPost.getUrl());
        return newPostPost;
    }

    public Post findbyname(PostPost postPost){
        return postRepository.findByNameOfPost(postPost.getName());
    }

    public PostPost updatePost(Long id, PostPost postPost){
        Post newPost = postRepository.findById(id).get();
        newPost.setNameOfPost(postPost.getName());
        postRepository.save(newPost);
        PostPost newPostPost = new PostPost();
        newPostPost.setName(newPost.getNameOfPost());
        return newPostPost;
    }
}
