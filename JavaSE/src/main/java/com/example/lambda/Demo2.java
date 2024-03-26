package com.example.lambda;

import java.util.function.IntBinaryOperator;

public class Demo2 {
    public static void main(String[] args) {
        //1.lambda函数替代匿名函数
        int num = calculateNum((left, right) -> left + right);
        new Thread(() -> {
            System.out.println("你好啊，这里是地球.");
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程中的方法被执行了");
            }
        }).start();

    }

    public static int calculateNum(IntBinaryOperator operator){
        int a = 20;
        int b = 30;
        return operator.applyAsInt(a, b);
    }
}
