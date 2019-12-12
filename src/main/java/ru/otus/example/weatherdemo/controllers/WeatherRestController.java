package ru.otus.example.weatherdemo.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.example.weatherdemo.model.Weather;
import ru.otus.example.weatherdemo.services.WeatherService;

import java.util.List;

@RestController
public class WeatherRestController {

    private final WeatherService weatherService;

    public WeatherRestController(@Qualifier("yandexWeatherService") WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("api/weather")
    public List<Weather> getWeather() {
        return weatherService.gWeather();
    }

}
