package com.example.LibraryManagement.controller;

import com.example.LibraryManagement.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public List<Student> getStudents(HttpServletRequest request) {
        HttpSession session = request.getSession();
        System.out.println("Session ID: " + session.getId());
        return students;
    }

    @PostMapping("/addstudent")
    public Student addstudent(@RequestBody Student student){
        students.add(student);
        return student;
    }

    @GetMapping("/csrf-token1")
    public CsrfToken getToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
