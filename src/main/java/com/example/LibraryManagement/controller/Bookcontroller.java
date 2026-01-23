package com.example.LibraryManagement.controller;

import com.example.LibraryManagement.model.Book;
import com.example.LibraryManagement.service.Bookservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class Bookcontroller {

    @Autowired
    public Bookservice service;

    @GetMapping("/get")
    public List<Book> getBooks() {
        return service.getallbooks();
    }

    @PostMapping("/add")
    public Book addBook(@RequestBody Book book) {
        Book book1 = service.addingbook(book);
        return book1;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book book) {
        book.setId(id);
        Book book2 = service.updatedbook(book);
        return new ResponseEntity<>(book2, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> deleteproduct(@PathVariable int id, @RequestBody Book book) {
        book.setId(id);
        Book book3 = service.removebook(book);
        return new ResponseEntity<>(book3, HttpStatus.OK);
    }


}
