package com.example.weather.schedule;

import com.example.weather.model.entity.City;
import com.example.weather.repository.CityRepository;
import com.example.weather.model.entity.Weather;
import com.example.weather.repository.WeatherRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class WeatherSchedule {

    private final WeatherRepository weatherRepository;

    private final CityRepository cityRepository;
    @Autowired
    public  WeatherSchedule(WeatherRepository weatherRepository , CityRepository cityRepository)
    {
        this.weatherRepository = weatherRepository;
        this.cityRepository = cityRepository;
    }

    @Scheduled(fixedRate = 300000)
    public void requestToWeatherApi() {
        List<City> cityList = cityRepository.findAll();
        for (City city : cityList) {
            String uri = "http://api.weatherapi.com/v1/current.json?key=389e4445ead8485fb8a152023220406&q=" + city.getName();
            RestTemplate getWeather = new RestTemplate();
            String result = getWeather.getForObject(uri, String.class);

            JSONObject parser = new JSONObject(result);
            JSONObject current = parser.getJSONObject("current");
            JSONObject location = parser.getJSONObject("location");
            Weather Data = new Weather(
                    location.getString("name"),
                    current.getFloat("temp_f"),
                    current.getFloat("temp_c"),
                    current.getString("last_updated")
            );
            weatherRepository.save(Data);
        }
    }
}
