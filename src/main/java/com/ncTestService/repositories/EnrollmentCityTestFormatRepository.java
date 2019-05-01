package com.ncTestService.repositories;

import com.ncTestService.models.City;
import com.ncTestService.models.EnrollmentCityTestFormat;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EnrollmentCityTestFormatRepository extends CrudRepository<EnrollmentCityTestFormat, Long> {

    List<EnrollmentCityTestFormat> findByActiveTrue();

    List<EnrollmentCityTestFormat> findByCity(City city);

}
