package com.example.weather.app.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WeatherApiResponse {
    private String resolvedAddress;
    private List<Day> days;

    // getters & setters

    @Getter
    @Setter
    public static class Day {
        private String datetime;
        private double tempmax;
        private double tempmin;
        private double temp;
        private String conditions;
        private List<Hour> hours;
    }

    @Getter
    @Setter
    public static class Hour {
        private String datetime;
        private double temp;
        private String conditions;
    }
}
