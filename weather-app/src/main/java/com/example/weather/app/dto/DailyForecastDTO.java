package com.example.weather.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DailyForecastDTO {
    private String date;
    private double minTemp;
    private double maxTemp;
    private double temp;
    private String condition;
}
