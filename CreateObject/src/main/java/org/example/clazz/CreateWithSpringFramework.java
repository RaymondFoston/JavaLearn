package org.example.clazz;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CreateWithSpringFramework {
    public static void main(String[] args) {
        Include_Static_Constructor_method_class.staticFunction();
        System.out.println("------------------------");
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Include_Static_Constructor_method_class myClass = (Include_Static_Constructor_method_class)applicationContext.getBean("clazz");
        myClass.function();
    }
}
