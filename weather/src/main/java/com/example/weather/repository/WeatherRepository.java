package com.example.weather.repository;

import com.example.weather.model.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WeatherRepository extends JpaRepository<Weather, Long> {
    List<Weather> findByCityOrderByIdDesc(String city);

    @Query(value = "SELECT w.* FROM weather w INNER JOIN ( SELECT ww.city,MAX(ww.id) AS max_id FROM weather ww GROUP BY ww.city ) ww ON w.id = ww.max_id" , nativeQuery = true)
    List<Weather> allCityStatus();
}
