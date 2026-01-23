package com.example.LibraryManagement.repository;

import com.example.LibraryManagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Bookrepo extends JpaRepository<Book,Integer> {

}
