package com.exam.weather.service;

import com.exam.weather.entity.Weather;
import com.exam.weather.exception.WeatherException;

public interface WeatherService {

    Weather getWeather(String city) throws WeatherException;

}
