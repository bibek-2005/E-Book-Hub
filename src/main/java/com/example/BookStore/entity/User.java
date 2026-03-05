package com.example.BookStore.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;// user id is the primary key

    private String name;

    private String email;
    @Column(unique = true)
    private String password;
    private String role;

}
