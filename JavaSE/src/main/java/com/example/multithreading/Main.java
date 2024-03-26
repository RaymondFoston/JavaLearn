package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();

        MyThread2 myThread2 = new MyThread2();
        Thread thread = new Thread(myThread2);
        thread.start();
    }

}