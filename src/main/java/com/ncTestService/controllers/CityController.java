package com.ncTestService.controllers;

import com.ncTestService.models.City;
import com.ncTestService.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping("cities")
    List<City> getCities() {
        return cityService.findAll();
    }

}
