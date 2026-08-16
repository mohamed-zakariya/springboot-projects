package com.example.weather.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HourlyForecastDTO {
    private String time;
    private double temp;
    private String condition;
}
