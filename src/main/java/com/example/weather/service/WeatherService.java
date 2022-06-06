package com.example.weather.service;

import com.example.weather.model.entity.Weather;
import com.example.weather.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherService {
    private final WeatherRepository weatherRepository;

    @Autowired
    public WeatherService(WeatherRepository weatherRepository)
    {
        this.weatherRepository = weatherRepository;
    }

    public List<Weather> getAllCityLastStatus()
    {
        return weatherRepository.allCityStatus();
    }

    public List<Weather> getByCity(String city) {
        return weatherRepository.findByCityOrderByIdDesc(city);
    }
}
