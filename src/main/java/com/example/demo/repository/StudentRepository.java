package com.example.demo.repository;

import com.example.demo.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByName(String name);

    List<Student> findByAddress(String address);

    List<Student> findByAge(int age);

    List<Student> findByNameOrderByAge(String name);

    List<Student> findAllByAgeGreaterThan(int age);

}
