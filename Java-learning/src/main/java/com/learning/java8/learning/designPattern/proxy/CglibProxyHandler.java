package com.learning.java8.learning.designPattern.proxy;

import com.learning.java8.utils.MonitorUtil;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyHandler<T> implements MethodInterceptor {

    private T target;

    @SuppressWarnings("unchecked")
    public T getInstance(final T target) {

        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return (T) enhancer.create();

    }

    /**
     * 注意MethodProxy中invoke和invokeSuper的区别
     * 若使用的是invokeSuper(o, objects)，则实现类this指向的是生成的cglib子类，即使方法实现中是进行的内部调用，仍然会经过责任链中的filter
     * 若使用的是invoke(this.target, objects)，需要注意target是传入的，未被增强，内部调用不会被重复包装。例Spring Aop
     *
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("cglib动态代理：" + "执行函数方法：" + method);
        MonitorUtil.start();
        Object result = methodProxy.invoke(this.target, objects);
        System.out.println("result：" + result);
        MonitorUtil.finish(method.getName());
        return result;

    }

}
