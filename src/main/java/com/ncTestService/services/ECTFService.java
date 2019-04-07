package com.ncTestService.services;

import com.ncTestService.models.City;
import com.ncTestService.models.Enrollment;
import com.ncTestService.models.EnrollmentCityTestFormat;

import java.util.List;

public interface ECTFService {

    EnrollmentCityTestFormat getECTF(Long id);
    List<EnrollmentCityTestFormat> getECTF(City city);
    List<EnrollmentCityTestFormat> getECTF(Enrollment enrollment);

}
