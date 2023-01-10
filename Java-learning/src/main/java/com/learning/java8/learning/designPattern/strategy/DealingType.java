package com.learning.java8.learning.designPattern.strategy;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface DealingType {

    String type() default "default";

}
