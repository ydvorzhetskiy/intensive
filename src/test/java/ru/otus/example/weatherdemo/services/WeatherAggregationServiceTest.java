package ru.otus.example.weatherdemo.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.otus.example.weatherdemo.model.Weather;

import java.util.Collections;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@DisplayName("Класс WeatherAggregationService")
@SpringBootTest
class WeatherAggregationServiceTest {

    @MockBean(name = "openWeatherService")
    private OpenWeatherService openWeatherService;

    @MockBean(name = "yandexWeatherService")
    private YandexWeatherService yandexWeatherService;

    @Autowired
    private WeatherAggregationService weatherAggregationService;

    @BeforeEach
    void setUp() {
        when(openWeatherService.gWeather())
                .thenReturn(singletonList(new Weather("", "", "")));
        when(yandexWeatherService.gWeather())
                .thenReturn(singletonList(new Weather("", "", "")));
    }

    @DisplayName("должне аггрегировать данные о погоде с разных сервисов")
    @Test
    void shouldAggregate() {
        assertThat(weatherAggregationService.gWeather()).hasSize(2);
    }
}
