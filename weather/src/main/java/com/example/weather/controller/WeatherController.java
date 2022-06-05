package com.example.weather.controller;

import com.example.weather.model.Response;
import com.example.weather.model.entity.City;
import com.example.weather.model.entity.Weather;
import com.example.weather.repository.CityRepository;
import com.example.weather.service.WeatherService;
import jdk.jfr.ContentType;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/weather")
public class WeatherController {

    private final WeatherService weatherService;
    private final CityRepository cityRepository;

    @Autowired
    public WeatherController(WeatherService weatherService , CityRepository cityRepository)
    {
        this.weatherService = weatherService;
        this.cityRepository = cityRepository;
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<?> getAllCityLastStatus()
    {
        Response response = new Response(
                weatherService.getAllCityLastStatus()
        );
        return  new ResponseEntity<>(response,HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{city}")
    public @ResponseBody ResponseEntity<?> getByCity(@PathVariable(value="city") String city)
    {
        Optional<City> ifCityExists = cityRepository.findCitiesByName(city);
        if(ifCityExists.isPresent()) {
            return new ResponseEntity<>(
                    new Response(
                            weatherService.getByCity(city)
                    ),
                    HttpStatus.OK
            );
        }
        return new ResponseEntity<>(
                new Response("404 Page Not Found",404),
                HttpStatus.NOT_FOUND
        );
    }
}
