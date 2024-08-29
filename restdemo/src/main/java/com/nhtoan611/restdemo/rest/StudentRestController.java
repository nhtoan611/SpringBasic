package com.nhtoan611.restdemo.rest;

import com.nhtoan611.restdemo.entity.Student;
import com.nhtoan611.restdemo.entity.StudentErrorResponse;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    List<Student> studentArrayList;

    @PostConstruct
    public void loadData() {
        studentArrayList = new ArrayList<>();
        studentArrayList.add(new Student("A", "B"));
        studentArrayList.add(new Student("C", "D"));
        studentArrayList.add(new Student("E", "F"));
    }

    @GetMapping("/students")
    public List<Student> getListStudent() {
        return studentArrayList;
    }

    @GetMapping("/student/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {
        if (studentId >= studentArrayList.size() || studentId <0) {
            throw new StudentNotFoundException("Not found Student ID: " + studentId);
        }
        return studentArrayList.get(studentId);
    }
}
