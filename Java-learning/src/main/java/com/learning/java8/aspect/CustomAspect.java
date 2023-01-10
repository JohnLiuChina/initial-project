package com.learning.java8.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

@Aspect
@Component
public class CustomAspect {

    @Pointcut("@annotation(com.learning.java8.aspect.Custom)")
    public void pointcut(){};

    @After("pointcut()")
    public void doAfter(JoinPoint joinPoint) throws NoSuchMethodException {

        MethodSignature ms = (MethodSignature)joinPoint.getSignature();
        /**
         * 此处不使用((MethodSignature)joinPoint.getSignature()).getMethod()获取Method，
         * 因为如果方法是接口的实现获取到的将是该方法接口
         */
        Method method = joinPoint.getTarget().getClass().getDeclaredMethod(ms.getName(), ms.getParameterTypes());
        Custom mi = method.getAnnotation(Custom.class);
        String info = mi.info();
        System.out.println("CustomAspect entered. Custom info is:" + info);

    }

}
