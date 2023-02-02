package com.exam.weather.service.impl;

import com.exam.weather.entity.Weather;
import com.exam.weather.exception.WeatherException;
import com.exam.weather.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Slf4j
@Service
public class WeatherContext {

    private List<WeatherService> dataSources;

    @Autowired
    public void setDataSources(List<WeatherService> dataSources) {
        this.dataSources = dataSources;
    }

    public Weather getWeather(String city) throws WeatherException {
        if (StringUtils.isEmpty(city)) {
            throw new WeatherException("City name is empty!", HttpStatus.NOT_FOUND.value());
        }
        Weather result = null;
        for (WeatherService dataSource : dataSources) {
            if (result != null) {
                break;
            }
            try {
                result = dataSource.getWeather(city);
            } catch (Exception e) {
                log.error("Get Weather error:", e);
            }
        }
        if (StringUtils.isEmpty(result)) {
            throw new WeatherException("All weather service is not available!", HttpStatus.BAD_REQUEST.value());
        }
        return result;
    }

}
