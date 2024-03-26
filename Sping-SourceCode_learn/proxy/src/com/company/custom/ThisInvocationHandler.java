package com.company.custom;

import java.lang.reflect.Method;

public interface ThisInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}

