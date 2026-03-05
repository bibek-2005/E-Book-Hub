package com.example.BookStore.repository;

import com.example.BookStore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User>findByEmail(String email);

    Optional<User>findByName(String name);
    // work of Optional -Because Email of a user may or may not exist.
}
