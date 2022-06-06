package com.example.weather.service;

import com.example.weather.model.Response;
import com.example.weather.model.entity.City;
import com.example.weather.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository)
    {
        this.cityRepository = cityRepository;
    }

    public List<City> getListOfCities() {
        return cityRepository.findAll();
    }

    public ResponseEntity<?> addNewCity(City city) {
        Optional<City> cityByName = cityRepository.findCitiesByName(city.getName());

        if(cityByName.isPresent())
        {
            return new ResponseEntity<>(
                    new Response("The City " + city.getName() + " already exists." , 409),
                    HttpStatus.CONFLICT
            );
        }
        else
        {
            cityRepository.save(city);
            return new ResponseEntity<>(
                    new Response(),
                    HttpStatus.OK
            );
        }
    }
}
