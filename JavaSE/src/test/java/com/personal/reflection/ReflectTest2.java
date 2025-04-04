package com.personal.reflection;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * 获取目标类的信息：成员变量，成员方法，构造方法，注解等等
 */
public class ReflectTest2 {
    private Class c;
    @Before
    public void initialize() throws ClassNotFoundException {
        String className = "com.JavaSE.reflection.User";
        c = Class.forName(className);
    }

    /**
     * 一、获取成员变量：
     * 1).getFields()——获取所有公有成员变量
     * 2).getField(String name)——获取指定名称的公有成员变量，会抛出NoSuchFieldException异常
     * 3).getDeclaredFields()——获取所有成员变量，不关乎权限
     * 4).getDeclaredFields()——获取指定名称的成员变量，不关乎权限，会抛出NoSuchFieldException异常
     * @throws ClassNotFoundException
     * @throws NoSuchFieldException
     */
    @Test
    public void test1() throws NoSuchFieldException {

        //1.
        System.out.println("1.-=-=-=-=-=-=-=-=-=-");
        for (Field field: c.getFields()){
            fieldPrint(field);
        }
        //2.
        System.out.println("2.-=-=-=-=-=-=-=-=-=-");
        fieldPrint(c.getField("name"));
        //3.
        System.out.println("3.-=-=-=-=-=-=-=-=-=-");
        for (Field field: c.getDeclaredFields()){
            fieldPrint(field);
        }
        //4.
        System.out.println("4.-=-=-=-=-=-=-=-=-=-");
        fieldPrint(c.getDeclaredField("id"));
    }

    /**
     * 二、获取方法、参数信息
     * 1. getMethods()——获取所有公有方法
     * 2. getMethod(String methodName, Class<?> parameterTypes)——根据方法及形参列表获取公有方法，会抛出NoSuchMethodException异常
     * 3. getDeclaredMethods()——获取所有方法
     * 4. getDeclaredMethod(String methodName, Class<?> parameterTypes)——根据方法及形参列表获取方法，会抛出NoSuchMethodException异常
     * getParameters()——获取所有形参
     */
    @Test
    public void test2() throws NoSuchMethodException {
        //1.获取所有共有方法
        System.out.println("1.-=-=-=-=-=-=-=-=-=-");
        for (int i = 0 ; i < c.getMethods().length; i++){
            System.out.println("第"+(i+1)+"个方法");
            methodPrint(c.getMethods()[i]);
        }
        //2.获取指定共有方法
        System.out.println("2.-=-=-=-=-=-=-=-=-=-");
        methodPrint(c.getMethod("setId",Integer.class));
    }

    /**
     * 三、获取构造方法信息
     * 1. getConstructors()——获取所有公有构造器
     * 2. getConstructor(Class<?> parameterTypes)——根据形参列表获取某一公有构造器
     * 3. getDeclaredConstructors()——获取所有构造器
     * 4. getDeclaredConstructor(Class<?> parameterTypes)——根据形参列表获取某一构造器
     */
    @Test
    public void test3(){
        Constructor[] constructors = c.getConstructors();
        for (Constructor c: constructors){
            System.out.println("Constructor's name: "+c.getName());
            System.out.println("Constructor's type: "+c.getTypeParameters());
            System.out.println("- - - - - - - - - - - - - - - - - - - - - ");
        }
    }

    private static void fieldPrint(Field field) {
        // 输出变量类型
        System.out.println(field.getType().getName());
        // 输出变量名
        System.out.println(field.getName());
    }
    private static void methodPrint(Method method){
        //输出方法名
        System.out.println("Method name: "+method.getName());
        //输出方法返回值类型名
        System.out.println("Method type:" + method.getReturnType().getName());
        //输出形参相关信息
        Parameter[] parameters = method.getParameters();
        int i = 0;
        for (Parameter parameter: parameters){
            System.out.println("第"+ ++i +"个形参信息");
            //形参名
            System.out.println("Parameter name: " + parameter.getName());
            //形参类型名
            System.out.println("Parameter type: " + parameter.getType().getName());
        }
        System.out.println("...................");
    }
}
