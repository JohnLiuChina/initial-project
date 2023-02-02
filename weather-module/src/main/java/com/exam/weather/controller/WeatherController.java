package com.exam.weather.controller;

import com.exam.weather.entity.Weather;
import com.exam.weather.exception.WeatherException;
import com.exam.weather.service.impl.WeatherContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/weather")
public class WeatherController {

    @Autowired
    private WeatherContext weatherContext;

    @GetMapping("/{city}")
    public Weather getWeather(@PathVariable String city) throws WeatherException {
        return weatherContext.getWeather(city);
    }

}
