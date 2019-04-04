package com.ncTestService.repositories;

import com.ncTestService.models.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Long> {
    Country findByName(String Name);
}
