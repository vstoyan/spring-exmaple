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

    /**
     * Welcome
     * Welcome
     */

    @GetMapping("/welcome")
    public String getWelcomeMessage(){
        return this.welcomeMessage;
    }

    /**
     * Get Student by Id
     * @param id
     *  Id of student
     * @return
     *  {@link Student}
     */
    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id){
        return ResponseEntity.ok(this.studentService.getStudentById(id));
    }

    @PutMapping("/student")
    public ResponseEntity<?> createStudent(@RequestBody Student student){
        Student result = this.studentService.createStudent(student);
        if (result !=null) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
