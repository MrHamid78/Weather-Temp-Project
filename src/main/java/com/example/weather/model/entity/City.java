package com.example.weather.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long id;
    private String name;
    private LocalDateTime created_at;


    public City() {
    }

    public City(Long id, String name) {
        this.id = id;
        this.name = name;
        this.created_at = LocalDateTime.now();
    }
    public City(String name) {
        this.name = name;
        this.created_at = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }
    public void setCreated_at() {
        this.created_at = LocalDateTime.now();
    }
}
