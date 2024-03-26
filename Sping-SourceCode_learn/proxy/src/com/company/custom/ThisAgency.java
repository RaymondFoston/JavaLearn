package com.company.custom;

import com.company.jdk.Person;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ThisAgency implements ThisInvocationHandler {


    private Person target;

    //获取代理对象的信息
    public  Object getInstance(Person target) throws Exception{
        this.target = target;
        Class clazz = target.getClass();
        System.out.println("Proxy is :"+ clazz);
        return ThisProxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
