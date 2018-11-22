package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student){
        return this.studentRepository.save(student);
    }

    public List<Student> findAllStudents(){
        return this.studentRepository.findAll();
    }

    public Student getStudentById(int id){
        return studentRepository.getOne(id);
    }
}
