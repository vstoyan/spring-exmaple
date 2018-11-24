package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StundentController {

    private StudentService studentService;

    @Value("${welcomeMessage}")
    private String welcomeMessage;

    @Autowired
    public StundentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStundents() {
        return ResponseEntity.ok(this.studentService.findAllStudents());
    }

    @GetMapping("/welcome")
    public String getWelcomeMessage(){
        return this.welcomeMessage;
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable int id){
        Student result = this.studentService.getStudentById(id);
        if (result !=null) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/studentByName/{name}")
    public ResponseEntity<?> getStudentByName(@PathVariable String name){
        List<Student> result = this.studentService.findByName(name);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/student")
    public ResponseEntity<?> createStudent(@RequestBody Student student){
        this.studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
