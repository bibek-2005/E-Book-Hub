package com.example.BookStore.controller;

import com.example.BookStore.entity.Book;
import com.example.BookStore.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/{books}")
public class BookController {

    @Autowired
    private  BookService service;
    public BookController(BookService service){
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<Book> addBook(@Valid @RequestBody Book book){
        Book saveBook = service.saveBook(book); // the book is saved on the save book then it add it on the ResponseEnity
        return new ResponseEntity<>(saveBook, HttpStatus.CREATED);
    }
    @GetMapping
    public List<Book> getAllBooks(Book book){
        return service.getAllBook(book);
    }
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id){
        return service.getBookById(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable Long id){
        service.deleteBookById(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/{id}")
    public Book changeBook(@PathVariable Long id,@Valid @RequestBody Book book){
        return service.updateBook(id,book);
    }
    @GetMapping("/search")
    public List<Book> searchBookByName(@RequestParam String title){
        return service.searchBook(title);
    }



}
