package com.example.weather.app.service;

import com.example.weather.app.dto.DailyForecastDTO;
import com.example.weather.app.dto.HourlyForecastDTO;
import com.example.weather.app.dto.WeatherApiResponse;
import com.example.weather.app.dto.WeatherResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class WeatherService {


    @Value("${weather.api.base-url}")
    private String baseUrl;

    @Value("${weather.api.key}")
    private String apiKEY;

    @Cacheable(value = "weather", key = "#city.toLowerCase()")
    public WeatherResponseDTO getWeather(String city) {

        String url = baseUrl + "/" + city + "?key=" + apiKEY;

        RestTemplate restTemplate = new RestTemplate();

        WeatherApiResponse weatherApiResponse = restTemplate.getForObject(
                url, WeatherApiResponse.class);

        // Mappping
        WeatherResponseDTO responseDTO = new WeatherResponseDTO();

        if (weatherApiResponse == null) {
            throw new RuntimeException("Weather API returned null response for city: " + city);
        }

        // Location
        responseDTO.setLocation(weatherApiResponse.getResolvedAddress());

        // Today's Forecast
        List<HourlyForecastDTO> todayList = weatherApiResponse.getDays().getFirst()
                .getHours()
                .stream()
                .map(h -> {
                    HourlyForecastDTO dto = new HourlyForecastDTO();
                    dto.setTime(h.getDatetime());
                    dto.setTemp(toCelsius(h.getTemp()));
                    dto.setCondition(h.getConditions());
                    return dto;
                }).toList();

        responseDTO.setTodayForecast(todayList);

        // 7 Days

        List<DailyForecastDTO> daysList = weatherApiResponse.getDays()
                .stream()
                .limit(7)
                .map(d -> {
                    DailyForecastDTO dto = new DailyForecastDTO();
                    dto.setDate(d.getDatetime());
                    dto.setMinTemp(toCelsius(d.getTempmin()));
                    dto.setMaxTemp(toCelsius(d.getTempmax()));
                    dto.setTemp(toCelsius(d.getTemp()));
                    dto.setCondition(d.getConditions());
                    return dto;
                }).toList();

        responseDTO.setWeeklyForecast(daysList);

        return responseDTO;
    }

    private static double toCelsius(double f) {
        return Math.round(((f - 32) / 1.8) * 10.0) / 10.0; // 1 decimal
    }


}
