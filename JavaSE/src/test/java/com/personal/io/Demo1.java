package com.personal.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 读取控制台的输入
 */
public class Demo1 {
    private  BufferedReader bufferedReader;
    public static void main(String[] args) throws IOException {
        Demo1 demo = new Demo1();
        demo.character();
        demo.string();
    }
    private void string() throws IOException {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please input string:");
        String s  ;
        s = bufferedReader.readLine();
        System.out.println("Your input is : " + s);

    }
    private void character() throws IOException {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please input character:");
        char c  ;
        c = (char) bufferedReader.read();
        System.out.println("Your input is : " + c);
    }
}
