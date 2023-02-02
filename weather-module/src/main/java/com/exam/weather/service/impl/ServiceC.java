package com.exam.weather.service.impl;

import com.exam.weather.common.DataSource;
import com.exam.weather.entity.Weather;
import com.exam.weather.exception.WeatherException;
import com.exam.weather.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@DataSource(dataSource = "http://c.etouch.cn/weather_mini?city=")
public class ServiceC implements WeatherService {

    private final String baseUrl = this.getClass().getAnnotation(DataSource.class).dataSource();

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Weather getWeather(String city) throws WeatherException {
        ResponseEntity<Weather> resp = restTemplate.getForEntity(baseUrl.concat(city), Weather.class);
        if (!resp.getStatusCode().is2xxSuccessful()) {
            log.error("datasource:{} get weather error, resp:{}", baseUrl, resp);
            throw new WeatherException("Get weather from datasource C error!", resp.getStatusCodeValue());
        }
        return resp.getBody();
    }
}
