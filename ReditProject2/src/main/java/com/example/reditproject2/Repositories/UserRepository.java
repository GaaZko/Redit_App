package com.example.reditproject2.Repositories;

import com.example.reditproject2.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    boolean existsByNameOfUser(String name);

    boolean existsByPasswordOfUser(String password);

    User findByNameOfUser(String name);
}
