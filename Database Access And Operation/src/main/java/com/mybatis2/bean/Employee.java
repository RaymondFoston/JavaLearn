package com.mybatis2.bean;

import org.apache.ibatis.type.Alias;

//@Alias("Emp")
public class Employee {

    private  Integer id;
    private String lastName;
    private  Integer Gendor;
    private String email;
    private Department department;

    public Employee(){super();}
    public Employee(String lastName, Integer Gendor, String email) {
        super();//???什么意义？
        this.lastName = lastName;
        this.Gendor =  (Integer) Gendor;
        this.email = email;
    }

    public Employee(Integer id, String lastName, Integer gendor, String email) {
        this.id = id;
        this.lastName = lastName;
        Gendor = gendor;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", Gendor=" + Gendor +
                ", email='" + email + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getGendor() {
        return Gendor;
    }

    public void setGendor(Integer Gendor) {
        this.Gendor = Gendor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
