package com.example.weather.config;

import com.example.weather.model.entity.City;
import com.example.weather.repository.CityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CityConfig {
    @Bean
    CommandLineRunner commandLineRunner(CityRepository repository)
    {
        return args -> {
            City london = new City("London");
            City tehran = new City("tehran");
            repository.saveAll(
                    List.of(london,tehran)
            );
        };
    }
}
