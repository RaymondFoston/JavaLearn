package com.example.lambda;

import java.util.ArrayList;

public class Demo1 {

    public static void main(String[] args) {
        //lambda表达式
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(5);
        numbers.add(9);
        numbers.add(8);
        numbers.add(1);
        numbers.forEach((n) -> {
            System.out.println(n);
        });

    }

}
