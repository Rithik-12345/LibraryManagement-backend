package com.example.LibraryManagement.service;

import com.example.LibraryManagement.model.Book;
import com.example.LibraryManagement.repository.Bookrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Bookservice {

    @Autowired
    private Bookrepo repo;

    public List<Book> getallbooks() {
        repo.findAll();
        return repo.findAll();
    }

    public Book addingbook(Book book) {
       return repo.save(book);

    }

    public Book updatedbook(Book book) {
        return repo.save(book);
    }

    public Book removebook(Book book) {
        repo.deleteById(book.getId());
        return book;
    }
}
