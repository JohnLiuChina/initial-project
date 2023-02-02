package com.exam.weather.global;

import com.exam.weather.entity.Weather;
import com.exam.weather.exception.WeatherException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(WeatherException.class)
    public Weather weatherErr(WeatherException e) {
        log.error("Global exception:{}", e.getMsg());
        return new Weather("16°C", "1°C", "阴");
    }

}
