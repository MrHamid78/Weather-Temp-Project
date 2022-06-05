package com.example.weather.controller;

import com.example.weather.model.Response;
import com.example.weather.service.CityService;
import com.example.weather.model.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/city")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService)
    {
        this.cityService = cityService;
    }
    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<?> getListOfCities()
    {
        return new ResponseEntity<>(
                new Response(
                        cityService.getListOfCities()
                ),
                HttpStatus.OK
        );
    }
    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<?> registerCity(@RequestBody City city)
    {
        return cityService.addNewCity(city);
    }
}
