package com.ncTestService.services.impl;


import com.ncTestService.models.EnrollmentCityTestFormat;
import com.ncTestService.repositories.EnrollmentCityTestFormatRepository;
import com.ncTestService.services.ECTFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ECTFServiceImpl implements ECTFService {

    private EnrollmentCityTestFormatRepository enrollmentCityTestFormatRepository;

    @Autowired
    public ECTFServiceImpl(EnrollmentCityTestFormatRepository enrollmentCityTestFormatRepository) {
        this.enrollmentCityTestFormatRepository = enrollmentCityTestFormatRepository;
    }

    @Override
    public List<EnrollmentCityTestFormat> getActiveECTF() {
        return enrollmentCityTestFormatRepository.findByActiveTrue();
    }

    @Override
    public EnrollmentCityTestFormat addECTF(EnrollmentCityTestFormat ectf) {
        return enrollmentCityTestFormatRepository.save(ectf);
    }
}
