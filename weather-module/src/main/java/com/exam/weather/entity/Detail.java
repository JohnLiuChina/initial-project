package com.exam.weather.entity;

import lombok.Data;

import java.util.List;

@Data
public class Detail {

    private List<Forecast> forecast;

}
