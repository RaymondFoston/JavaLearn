package com.example.practice;

class abcd {

    abcd(){
        System.out.println("dddddd");
    }

    static{
        System.out.println(21412);
    }
    public static void dd () {
        System.out.println("gggggg");
    }
}

public class statictest {
    public static void main(String[] args) {

        abcd.dd();
        System.out.println("------");
        new abcd();

    }
}
