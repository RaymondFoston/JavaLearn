package com.company.custom;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ThisProxy {
    public static Object newProxyInstance(ThisClassLoader loader,
                                          Class<?>[] interfaces,
                                          ThisInvocationHandler h){
        return null;
    }
}
