package com.learning.java8;

import com.learning.java8.learning.designPattern.proxy.CglibProxyHandler;
import com.learning.java8.learning.designPattern.proxy.DynamicAppleProxyHandler;
import com.learning.java8.learning.designPattern.proxy.StaticAppleProxy;
import com.learning.java8.service.RegisteService;
import com.learning.java8.service.impl.RegistePearImpl;
import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.core.DebuggingClassWriter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

@Slf4j
@RunWith(SpringRunner.class)
public class ProxyTest {

    @Test
    public void staticProxyTest(){

        String registeUrl = "http://www.test.com";
        RegistePearImpl registeApple = new RegistePearImpl();
        StaticAppleProxy staticAppleProxy = new StaticAppleProxy(registeApple);
        staticAppleProxy.registe(registeUrl);

    }

    @Test
    public void sss(){

        int a = -1;
        System.out.println(Integer.toBinaryString(a));
        a = a << 29;
        System.out.println(Integer.toBinaryString(a));

    }

    @Test
    public void dynamicProxyTest(){

        String registeUrl = "http://www.test.com";
        RegistePearImpl register = new RegistePearImpl();
        InvocationHandler invocationHandler = new DynamicAppleProxyHandler<>(register);
        RegisteService registeService = (RegisteService) Proxy.newProxyInstance(RegisteService.class.getClassLoader(), new Class[]{RegisteService.class}, invocationHandler);
        registeService.registe(registeUrl);
        registeService.foreach();
        String jsonStr = registeService.getJsonStr();
        System.out.println(jsonStr);

    }

    @Test
    public void cglibTest(){

        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\develop\\cglib");
        RegisteService registePear = new RegistePearImpl();
        CglibProxyHandler<RegisteService> cglibProxyHandler = new CglibProxyHandler<>();
        RegisteService pearProxy = cglibProxyHandler.getInstance(registePear);
        pearProxy.foreach();

    }

}
