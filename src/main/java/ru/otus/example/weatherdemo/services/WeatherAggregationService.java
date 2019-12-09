package ru.otus.example.weatherdemo.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.example.weatherdemo.model.Weather;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class WeatherAggregationService implements WeatherService {

    private final List<WeatherService> weatherServices;

    @Override
    public List<Weather> gWeather() {
        List<Weather> weatherList = new ArrayList<>();
        weatherServices.forEach(ws -> weatherList.addAll(ws.gWeather()));
        return weatherList;
    }
}
