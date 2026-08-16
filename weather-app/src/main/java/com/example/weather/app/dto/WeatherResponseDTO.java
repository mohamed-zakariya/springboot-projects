package com.example.weather.app.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class WeatherResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String location;
    private List<HourlyForecastDTO> todayForecast;
    private List<DailyForecastDTO> weeklyForecast;
}
