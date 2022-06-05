package com.example.weather.model.entity;

import net.sf.cglib.core.Local;
import org.springframework.data.convert.Jsr310Converters;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String city;
    private Float temp_f;
    private Float temp_c;
    private LocalDateTime last_update;
    private LocalDateTime created_at;

    public Weather() {
    }
    public Weather(String city, Float temp_f, Float temp_c, LocalDateTime last_update , LocalDateTime created_at) {
        this.city = city;
        this.temp_f = temp_f;
        this.temp_c = temp_c;
        this.last_update = last_update;
        this.created_at = created_at;
    }
    public Weather(String city, Float temp_f, Float temp_c, String last_update) {
        this.city = city;
        this.temp_f = temp_f;
        this.temp_c = temp_c;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.last_update = LocalDateTime.parse(last_update, formatter);
        this.created_at = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Float getTemp_f() {
        return temp_f;
    }

    public void setTemp_f(Float temp_f) {
        this.temp_f = temp_f;
    }

    public Float getTemp_c() {
        return temp_c;
    }

    public void setTemp_c(Float temp_c) {
        this.temp_c = temp_c;
    }

    public LocalDateTime getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDateTime last_update) {
        this.last_update = last_update;
    }

    public LocalDateTime getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
}
