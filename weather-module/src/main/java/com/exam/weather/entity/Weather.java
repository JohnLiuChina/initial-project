package com.exam.weather.entity;

import lombok.Data;

@Data
public class Weather {

    private String high;
    private String low;
    private String weather;

    public Weather(){}

    public Weather(String high, String low, String weather) {
        this.high = high;
        this.low = low;
        this.weather = weather;
    }

}
