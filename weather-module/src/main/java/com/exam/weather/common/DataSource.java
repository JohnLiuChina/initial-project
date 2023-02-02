package com.exam.weather.common;

import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {

    String dataSource() default "http://wthrcdn.etouch.cn/weather_mini?city=";

}
