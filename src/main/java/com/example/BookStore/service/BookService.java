package com.example.BookStore.service;

import com.example.BookStore.entity.Book;
import com.example.BookStore.exception.BookNotFoundException;
import com.example.BookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private  BookRepository repo;
    public BookService(BookRepository repo) {
        this.repo = repo;
    }
    public Book saveBook(Book book) {
        return repo.save(book);
    }
    public List<Book> getAllBook(Book book){
        return repo.findAll();
    }
    public Book getBookById(Long id){
        return repo.findById(id).orElseThrow(()->new BookNotFoundException("Book Not Found with id: "+id));
    }
    public void deleteBookById(Long id){
        repo.deleteById(id);
    }

    public Book updateBook(Long id, Book book){
        Book existingBook  = repo.findById(id).orElseThrow(()->new BookNotFoundException("Book Not Found with id: "+id));

        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setPrice(book.getPrice());
        existingBook.setStock(book.getStock());
        return repo.save(existingBook);
    }
    public List<Book> searchBook(String bookname){
        return repo.findByTitleContainingIgnoreCase(bookname);
    }

}
