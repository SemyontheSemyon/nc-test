package com.ncTestService.dbInit.entitiesInit.Impl;

import com.ncTestService.dbInit.entitiesInit.CityInit;
import com.ncTestService.models.City;
import com.ncTestService.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CityInitImpl implements CityInit {

    @Autowired
    CityRepository cityRepository;

    @Override
    public void initCities() {

        List<City> list = new ArrayList<>();

        String[] cities = {"SPB", "MSK", "EKB", "NSK", "KZN"};

        for(String city : cities) {
            list.add(new City(city));
        }

        cityRepository.saveAll(list);

    }
}
