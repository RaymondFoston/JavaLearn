package com.company.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;






public class ProxyInstance implements InvocationHandler {
    private Person target;

    //获取代理对象的信息
    public  Object getInstance(Person target) throws Exception{
        this.target = target;
        Class clazz = target.getClass();
        System.out.println("Proxy is :"+ clazz);
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(this.target.getName());
        method.invoke(this.target,args);
        this.target.findLove();
        return null;
    }
}
