package com.example.LibraryManagement.controller;

import com.example.LibraryManagement.model.Book;
import com.example.LibraryManagement.service.Bookservice;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
public class Bookcontroller {

    @Autowired
    public Bookservice service;

    @GetMapping("/get")
        public List<Book> getBooks (HttpServletRequest request) {
            HttpSession session = request.getSession();
            System.out.println("Get session "+session.getId());
            System.out.println("is new session "+session.isNew());
            return service.getallbooks();
        }

    @PostMapping(value = "/add",consumes =  MediaType.MULTIPART_FORM_DATA_VALUE)
    public Book addBook(@RequestPart("book") Book book,@RequestPart("file") MultipartFile file) throws IOException {
        Book book1 = service.addingbook(book,file);
        return book1;
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Book> getBook(@PathVariable int id){
        Book book5 = service.getBookbyId(id);
        return new ResponseEntity<>(book5, HttpStatus.OK);
    }

    @GetMapping("/books/{id}/image")
    public ResponseEntity<byte[]> getBookImage(@PathVariable int id){
        Book book4 = service.getBookbyId(id);
        byte[] imageFile = book4.getImageData();
        String imageType = book4.getImageType();

        if(imageType == null || imageType.isBlank()){
            imageType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
        }
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(imageType))
                .body(imageFile);
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
