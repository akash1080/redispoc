package com.example.redispoc.controller;

import com.example.redispoc.dto.StudentRequest;
import com.example.redispoc.dto.StudentResponse;
import com.example.redispoc.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService businessClass;

//    private final Logger logger = LoggerFactory.getLogger(getClass());

    // get All Students

    @GetMapping("/")
    public ResponseEntity<List<StudentResponse>> getAllStudents() {
        List<StudentResponse> response = businessClass.findAllStudents();
        return ResponseEntity.ok(response);
    }

    // Add a student

    @PostMapping("/")
    public ResponseEntity<StudentResponse> addStudent(@RequestBody StudentRequest request) {
        StudentResponse response = businessClass.addStudent(request);
        return ResponseEntity.ok(response);
    }

    // get a student by id

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getStudentById(@PathVariable Integer id)
            throws NoSuchElementException {
        StudentResponse response = businessClass.getStudentById(id);
        return ResponseEntity.ok(response);
    }
}
