package com.example.practice;

public class duotaitest {
    public static void main(String[] args) {
        person person = new teacher();
        person.t1();
        person.t2();
        teacher t = new teacher();
        t.t2();
        final int d =2;

    }
}

class person {
    void t1 (){
        System.out.println(111);
    }
    void t2 () {
        System.out.println(2222);
    }
}
class teacher extends person{
    @Override
    void t1() {
        System.out.println("aaa");
    }
    void tt11 () {
        System.out.println("hello");
    }
}
