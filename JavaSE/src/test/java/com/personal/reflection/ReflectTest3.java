package com.personal.reflection;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 使用反射生成对象以及操作对象
 */
public class ReflectTest3 {
    private Class c;
    @Before
    public void initialize() throws ClassNotFoundException {
        String className = "com.JavaSE.reflection.User";
        c = Class.forName(className);
    }
    /**
     * 一、创建对象
     * 1. Class对象的newInstance()方法——调用默认构造创建实例
     * 2. Class对象获取指定Constructor对象，再调用该对象的newInstance()方法
     */
    @Test
    public void test1() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //1.
        User user1 = (User) c.newInstance();
        user1.name = "The first way!";
        user1.say();
        //2.
        User user2  = (User) c.getConstructor(Integer.class,String.class).
                newInstance(2,"The second way!");
        user2.say();
    }
    /**
     * 二、调用方法
     * Method对象的invoke(Object obj, Object args)——其中，第一个参数obj是
     * 执行该方法的主调（也就是一个拥有这个方法的对象），后面的arg是调用该方法的实参。
     */
    @Test
    public void test2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Method sayMethod1 = c.getMethod("say",String.class);
        //调用静态方法
        sayMethod1.invoke(null,"static method");
        //获取对象
        User user = (User) c.getConstructor(Integer.class,String.class).
                newInstance(1,"Invoke method!");
        Method sayMethod2 = c.getMethod("say",String[].class);
        sayMethod2.invoke(user, (Object)new String[]{"Hello","array parameters"});

    }
    /**
     * 三、修改成员变量值
     * Field对象的getXXX(Object obj)——obj为拥有该属性的对象，XXX为8种基本类型，代表着成员变量类型，如果成员变量为引用类型，则去掉XXX。
     * Field对象的setXXX(Object obj, XXX val)——obj同上，val为要设置的值
     */
    @Test
    public void test3() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        User user = (User) c.getConstructor(Integer.class, String.class).
                newInstance(1, "Invoke method!");
        Method sayMethod = c.getMethod("say", null);
        sayMethod.invoke(user, null);

        Field name = c.getField("name");
        name.set(user, "the method that changed the name!");
        sayMethod.invoke(user, null);
    }
}
