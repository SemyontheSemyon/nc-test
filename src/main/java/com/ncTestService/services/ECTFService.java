package com.ncTestService.services;

import com.ncTestService.models.EnrollmentCityTestFormat;

import java.util.List;

public interface ECTFService {

    List<EnrollmentCityTestFormat> getActiveECTF();

    EnrollmentCityTestFormat addECTF(EnrollmentCityTestFormat ectf);

}
