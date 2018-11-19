package com.example.demo.model;

public class Student {

    private String name;
    private int age;
    private String address;

    public Student(){}

    public Student (final String name, final int age, final String address){
        this.name = name;
        this.age = age;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
