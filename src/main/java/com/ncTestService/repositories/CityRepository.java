package com.ncTestService.repositories;

import com.ncTestService.models.City;
import com.ncTestService.models.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CityRepository extends CrudRepository<City, Long> {
    City findByName(String name);
    List<City> findByCountry(Country country);
}
