package com.example.demo.repository;

import com.example.demo.model.Student;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class StudentRepository {

    public List<Student> findAll() {
       return Collections.unmodifiableList(
                Arrays.asList(new Student("Gosho", 22, "Mladost"),
                                new Student("Pesho", 26, "Liulin"),
                                new Student("Lili", 25, "Nadezhda")));
    }

    public Student createStudent(Student student){
        System.out.println("Created student with: name" + student.getName() + " was created!");

        //Create student with this name so you can test what happens when creation in DB was not successful
        if (student.getName().equals("name")){
            return null;
        }
        return student;
    }

    public Student getStudentById(int id){
        return new Student("ID" + id, id, "Address " + id);
    }
}
