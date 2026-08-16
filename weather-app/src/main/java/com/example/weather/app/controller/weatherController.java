package com.example.weather.app.controller;

import com.example.weather.app.dto.WeatherResponseDTO;
import com.example.weather.app.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
public class weatherController {

    @Autowired
    private WeatherService weatherService;


    @GetMapping("/test")
    public String testWeather(){
        return "Welcome To Weather App";
    }

    @GetMapping("/{city}")
    public WeatherResponseDTO getWeather(@PathVariable String city){
        return weatherService.getWeather(city);
    }

}
