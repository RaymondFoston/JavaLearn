package com.company.jdk;

public class Hank implements Person {
    private String name = "Ivanka";
    private String sex = "female";
    @Override
    public void findLove() {
        System.out.println("My name is " + this.name + "." + "I am  "+ this.sex  + ".");
        System.out.println("Find lover!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
