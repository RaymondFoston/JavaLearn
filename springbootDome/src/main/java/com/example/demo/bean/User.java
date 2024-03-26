package com.example.demo.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户
 */
@Getter@Setter
public class User {
    private String name;
    private Integer age;
    private Pet pet;

    public User(){}

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", pet=" + pet +
                '}';
    }
}
