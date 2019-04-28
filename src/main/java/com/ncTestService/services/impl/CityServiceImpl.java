package com.ncTestService.services.impl;


import com.ncTestService.models.City;
import com.ncTestService.repositories.CityRepository;
import com.ncTestService.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {


    private CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<String> findAllNames() {
        List<String> cities = new ArrayList<>();
        cityRepository.findAll().forEach(city -> cities.add(city.getName()));
        return cities;
    }

    @Override
    public List<City> findAll() {
        return (List) cityRepository.findAll();
    }

    @Override
    public City findByName(String name) {
        return cityRepository.findByName(name);
    }

}
