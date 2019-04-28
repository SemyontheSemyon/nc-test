package com.ncTestService.services;

import com.ncTestService.models.City;

import java.util.List;

public interface CityService {

    List<String> findAllNames();

    List<City> findAll();

    City findByName(String name);

}
