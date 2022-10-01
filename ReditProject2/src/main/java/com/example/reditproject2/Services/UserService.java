package com.example.reditproject2.Services;

import com.example.reditproject2.Models.Post;
import com.example.reditproject2.Models.PostPost;
import com.example.reditproject2.Models.User;
import com.example.reditproject2.Models.UserDTO;
import com.example.reditproject2.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

   public void addUser(String name, String password) {
        userRepository.save(new User(name, password));
    }

   public boolean loginUser(String name, String password) {
       if (userRepository.existsByNameOfUser(name) && userRepository.existsByPasswordOfUser(password)) {
           return true;
       } else {
           return false;
       }
   }
   public Long getId(String name) {
        return userRepository.findByNameOfUser(name).getId();
   }

   public List<User> getAllUsers () {
       return userRepository.findAll();
   }

   public UserDTO restGetUser(Long id) {
       User newUser = userRepository.findById(id).get();
       UserDTO user = new UserDTO();
       user.setName(newUser.getNameOfUser());

       List<PostPost> list = new ArrayList<>();


       for (Post posts : newUser.getPosts()) {
           PostPost postPost = new PostPost();
           postPost.setName(posts.getNameOfPost());
           postPost.setUrl(posts.getUrl());
           list.add(postPost);
       }
       user.setPosts(list);
       return user;

   }
}
