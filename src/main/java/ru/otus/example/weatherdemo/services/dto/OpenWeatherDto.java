package ru.otus.example.weatherdemo.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OpenWeatherDto {

    @JsonProperty("main")
    private MainDto main;

    @Data
    public static class MainDto {

        @JsonProperty("temp")
        private String temperature;
    }
}
