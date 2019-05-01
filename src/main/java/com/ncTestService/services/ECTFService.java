package com.ncTestService.services;

import com.ncTestService.models.City;
import com.ncTestService.models.EnrollmentCityTestFormat;

import java.util.List;

public interface ECTFService {

    List<EnrollmentCityTestFormat> getActiveECTF();

    EnrollmentCityTestFormat addECTF(EnrollmentCityTestFormat ectf);

    List<EnrollmentCityTestFormat> findByCity(City city);

    void deleteECTF(Long id);

}
