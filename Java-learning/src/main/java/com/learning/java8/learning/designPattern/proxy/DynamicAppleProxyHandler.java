package com.learning.java8.learning.designPattern.proxy;

import com.learning.java8.utils.MonitorUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicAppleProxyHandler<T> implements InvocationHandler {

    T target;

    public DynamicAppleProxyHandler(T t) {
        this.target = t;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("动态代理：" + "执行函数方法：" + method);
        MonitorUtil.start();
        Object result = method.invoke(target, args);
        System.out.println("result：" + result);
        MonitorUtil.finish(method.getName());
        if (method.getName().equals("getJsonStr")) {
            result += "post handle";
        }
        return result;

    }

}
