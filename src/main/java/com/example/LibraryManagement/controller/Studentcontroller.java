package com.example.LibraryManagement.controller;

import com.example.LibraryManagement.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Studentcontroller {

    private List<Student> students = new ArrayList<>(List.of(
            new Student(1, "rithik", 60),
            new Student(2, "vikas", 51)
    ));

    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }
}
