package com.personal.reflection;


import junit.framework.Assert;
import org.junit.Test;

/**
 * 获取目标类的java.lang.Class对象
 * 1.使用Class的静态方法forName(类名称)，可能会抛出ClassNotFound异常
 * 2.使用类的class属性
 * 3.使用对象的getClass方法
 */
public class ReflectTest1 {

    @Test
    public void test1(){
        //获取java.lang.Class的三种方式
        //1.使用Class的静态方法forName(类名称)，可能会抛出ClassNotFound异常
        Class c1 = null;
        try {
            c1 = Class.forName("com.personal.reflection.User");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //2.使用类的class属性
        Class c2 = User.class;
        //3.使用对象的getClass方法
        Class c3 = (new User()).getClass();
        Assert.assertEquals(c1,c2);
        Assert.assertEquals(c2,c3);
        System.out.println(c1);
    }

}
