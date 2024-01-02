package com.springcourse.demo.rest;

import com.springcourse.demo.entity.Student;
import com.springcourse.demo.exceptions.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoRestControlller {

    private ArrayList<Student> theStudents;
    //add code for hello endpoint

    //populate theStudents array list using @PostConstruct since it is executed only once
    @PostConstruct
    private void addStudents(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Maaz", "Ahmad"));
        theStudents.add(new Student("Jimmy", "Choo"));
        theStudents.add(new Student("Park", "Davis"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentByStudentId(@PathVariable int studentId){

        //check the studentId against the list size
        if(studentId >= theStudents.size() || studentId < 0)
        {
            throw new StudentNotFoundException("Student Id nont found: " + studentId);
        }
        return theStudents.get(studentId);
    }




}
