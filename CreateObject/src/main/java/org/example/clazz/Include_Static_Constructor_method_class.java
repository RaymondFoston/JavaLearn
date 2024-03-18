package org.example.clazz;


public class Include_Static_Constructor_method_class {
    // 静态变量
    static int staticVariable1;
    static int staticVariable2;

    // 实例变量
    int instanceVariable1;
    int instanceVariable2;

    // 静态代码块
    static {
        staticVariable1 = 1;
        staticVariable2 = 2;
        System.out.println("Static code block can be called without creating objects");
    }

    static {
        staticVariable1 = 3;
        staticVariable2 = 4;
        System.out.println("Static code block can be called without creating objects");

    }

    // 代码块
    {
        instanceVariable1 = 5;
        instanceVariable2 = 6;
        System.out.println("Public code block must be called by creating objects");
    }

    {
        instanceVariable1 = 7;
        instanceVariable2 = 8;
        System.out.println("Public code block must be called by creating objects");
    }
    public static void staticFunction(){
        System.out.println("Static methods can be called without creating objects");
    }

    // 构造函数
    public Include_Static_Constructor_method_class() {
        instanceVariable1 = 9;
        instanceVariable2 = 10;
        System.out.println("Constructor must be called by creating objects");
    }

    //实例函数
    public void function(){
        System.out.println("Public methods must be called by creating objects");
    }
}
