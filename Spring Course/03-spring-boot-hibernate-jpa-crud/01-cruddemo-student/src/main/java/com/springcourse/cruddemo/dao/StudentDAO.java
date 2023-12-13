package com.springcourse.cruddemo.dao;

import com.springcourse.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);
    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findStudentByLastName(String lastName);
}
