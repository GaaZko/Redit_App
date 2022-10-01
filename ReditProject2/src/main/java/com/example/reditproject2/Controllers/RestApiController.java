package com.example.reditproject2.Controllers;

import com.example.reditproject2.Models.PostPost;
import com.example.reditproject2.Services.PostService;
import com.example.reditproject2.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

    final PostService postService;
    final UserService userService;
@Autowired
    public RestApiController(PostService postService, UserService userService) {
        this.postService = postService;
    this.userService = userService;
}


    @PostMapping("/postAdd")
    public ResponseEntity addNewPost (@RequestBody PostPost postPost) {
        if (postPost.getName() == null) {
            return ResponseEntity.status(400).body(null);

        } else if (postService.findbyname(postPost) == null) {
            return ResponseEntity.ok().body(postService.addNewPost(postPost));
        }
        return ResponseEntity.status(400).body(null);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updatePost (@PathVariable Long id, @RequestBody PostPost postPost){
    return ResponseEntity.ok().body(postService.updatePost(id,postPost));
    }

    @GetMapping("/allPosts/{id}")
    public ResponseEntity getAllPosts(@PathVariable Long id){
        return ResponseEntity.ok().body(userService.restGetUser(id));
    }




}
