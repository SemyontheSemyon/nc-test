package com.ncTestService.services.impl;


import com.ncTestService.models.City;
import com.ncTestService.models.Enrollment;
import com.ncTestService.models.EnrollmentCityTestFormat;
import com.ncTestService.repositories.EnrollmentCityTestFormatRepository;
import com.ncTestService.services.ECTFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ECTFServiceImpl implements ECTFService {

    @Autowired
    EnrollmentCityTestFormatRepository enrollmentCityTestFormatRepository;


    @Override
    public EnrollmentCityTestFormat getECTF(Long id) {
        return enrollmentCityTestFormatRepository.findById(id).get();
    }

    @Override
    public List<EnrollmentCityTestFormat> getECTF(City city) {
        return enrollmentCityTestFormatRepository.findByCity(city);
    }

    @Override
    public List<EnrollmentCityTestFormat> getECTF(Enrollment enrollment) {
        return enrollmentCityTestFormatRepository.findByEnrollment(enrollment);
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
