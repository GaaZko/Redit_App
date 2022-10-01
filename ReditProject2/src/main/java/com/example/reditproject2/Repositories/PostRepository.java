package com.example.reditproject2.Repositories;

import com.example.reditproject2.Models.Post;
import com.example.reditproject2.Models.PostPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    Post findByNameOfPost(String name);
}
