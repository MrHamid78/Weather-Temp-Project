package com.example.weather.repository;

import com.example.weather.model.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City,Long> {
    Optional<City> findCitiesByName(String name);
}
