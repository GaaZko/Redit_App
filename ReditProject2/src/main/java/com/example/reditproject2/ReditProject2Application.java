package com.example.reditproject2;

import com.example.reditproject2.Models.Post;
import com.example.reditproject2.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReditProject2Application implements CommandLineRunner {

    final PostRepository postRepository;
    @Autowired
    public ReditProject2Application(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ReditProject2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
     //   Post newPost = new Post();
      //  newPost.setNameOfPost("hahahah");
      //  newPost.setDisLikes(11);
       // newPost.setLikes(12);
        //newPost.setUrl("https://www.baeldung.com/java-type-casting");
        //postRepository.save(newPost);
    }
}
