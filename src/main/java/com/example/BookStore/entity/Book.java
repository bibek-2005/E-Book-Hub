package com.example.BookStore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Validated
@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // the id is  primary key

    @NotBlank(message="Book name cannot be empty")
    private String title;

    @NotBlank(message="Author can not be empty")
    private String author;

    @Positive(message="Price must be positive")
    private double price;

    @Min(value =0,message="stock can not be empty")
    private int stock;

}
