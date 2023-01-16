package com.example.markgeneratordemo.models;

public class StudentInfoModel {
    private int id;
    private String name;

    public StudentInfoModel() {
    }

    public StudentInfoModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
