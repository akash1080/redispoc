package com.example.redispoc.service;

import com.example.redispoc.dto.StudentRequest;
import com.example.redispoc.dto.StudentResponse;
import com.example.redispoc.entity.Student;
import com.example.redispoc.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Cacheable(value = "students")
    public List<StudentResponse> findAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentResponse> response = new ArrayList<>();
        for(Student student : students) {
            response.add(new StudentResponse(student.getRollNo(),student.getAge(),student.getName()));
        }
        logger.info("Retrieved info of all the students from DB");
        return response;
    }

    @CacheEvict(value = "students",allEntries = true)
    public StudentResponse addStudent(StudentRequest request) {
        Student student = new Student();
        student.setAge(request.getAge());
        student.setName(request.getName());
        student = studentRepository.save(student);
        logger.info("Student added with id:{} and cache deleted", student.getRollNo());
        return new StudentResponse(student.getRollNo(),student.getAge(),student.getName());
    }

    @Cacheable(value = "students", key = "#id")
    public StudentResponse getStudentById(Integer id) throws NoSuchElementException {
        //Student student = studentRepository.findById(id).get();
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(!optionalStudent.isPresent()) {
            logger.error("Method getStudentById threw exception: NoSuchElementException for Id: {}", id);
            throw new NoSuchElementException() ;
        }
        Student student = optionalStudent.get();
        logger.info("Retrieved info of student with id: {} from Database",id);
        return new StudentResponse(student.getRollNo(),student.getAge(),student.getName());
    }
}
