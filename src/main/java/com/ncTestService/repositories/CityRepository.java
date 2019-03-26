package com.ncTestService.repositories;

import com.ncTestService.models.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Long> {
}
