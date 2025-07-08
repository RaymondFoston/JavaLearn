package com.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@Alias("Emp")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private Integer id;
    private String lastName;
    private String gendor;
    private Integer age;
    private String email;
    private Department department;

    public Employee(Integer id, String lastName, String gendor, Integer age, String email) {
        this.id = id;
        this.lastName = lastName;
        this.gendor = gendor;
        this.age = age;
        this.email = email;
    }
}
