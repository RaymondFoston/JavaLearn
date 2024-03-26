package com.example.practice;

public class Hook {
    public static void function (Ta a){
        a.paint();
        System.out.println("abstract" );
    }

    public static void main(String[] args) {
        System.out.println("Wowoooooo!");
        function(new Taa());
    }
}


class Taa implements Ta{
    public void paint(){
        System.out.println("dfdsfdsg");

    }
}

interface Ta {
    void paint();
}