package com.personal.reflection;

public class User {
    private Integer id;
    public String name;

    //public constructor which does not have parameter
    public User(){}
    //pubic constructor which have parameter
    public User(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // method
    public void say(){
        System.out.println( "Hello, " + this.name);
    }
    public static void say(String name){
        System.out.println("Hello " + name);
    }
    public void say(String...words){
        for (int i=0; i < words.length; i++){
            System.out.print(words[i]+" ");
        }
    }
}
