package com.faizan.service.user.service.user;

public class Student {
    int id;

    String name;
    String address;
    String country;

    public Student(String name, String address, String country) {
        this.name = name;
        this.address = address;
        this.country = country;
    }

    public Student(int id, String name, String address, String country) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAddress() {
        return address;
    }

    public void setClass(String aClass) {
        address = aClass;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
