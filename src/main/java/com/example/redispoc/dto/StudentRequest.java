package com.example.redispoc.dto;

import com.example.redispoc.entity.Student;

import java.io.Serializable;

public class StudentRequest implements Serializable {

    private String name;
    private int age;

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
