package com.exam.weather.service.impl;

import com.exam.weather.common.DataSource;
import com.exam.weather.entity.Data;
import com.exam.weather.entity.Forecast;
import com.exam.weather.entity.Weather;
import com.exam.weather.exception.WeatherException;
import com.exam.weather.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Slf4j
@Service
@DataSource(dataSource = "http://wthrcdn.etouch.cn/weather_mini?city=")
public class ServiceA implements WeatherService {

    private final String baseUrl = this.getClass().getAnnotation(DataSource.class).dataSource();

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Weather getWeather(String city) throws WeatherException {
        ResponseEntity<Data> resp = restTemplate.getForEntity(baseUrl.concat(city), Data.class);
        if (!resp.getStatusCode().is2xxSuccessful()) {
            log.error("datasource:{} get weather error, resp:{}", baseUrl, resp);
            throw new WeatherException("Get weather from datasource A error!", resp.getStatusCodeValue());
        }
        Forecast forecast = Objects.requireNonNull(resp.getBody())
                .getData()
                .getForecast().stream()
                .findFirst()
                .orElse(new Forecast());
        return new Weather(forecast.getHigh(), forecast.getLow(), forecast.getType());
    }

}
