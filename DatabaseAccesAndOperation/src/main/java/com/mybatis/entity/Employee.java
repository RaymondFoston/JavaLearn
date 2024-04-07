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

    private  Integer id;
    private String lastName;
    private  Integer gendor;
    private String email;
    private Department department;
}
