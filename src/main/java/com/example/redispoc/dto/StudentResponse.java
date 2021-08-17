package com.example.redispoc.dto;

import com.example.redispoc.entity.Student;

import java.io.Serializable;

public class StudentResponse implements Serializable {

    private Integer rollNo;
    private String name;
    private int age;

    public StudentResponse(Integer rollNo, int age, String name) {
        this.rollNo = rollNo;
        this.age = age;
        this.name = name;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
