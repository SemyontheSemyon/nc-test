package com.ncTestService.dbInit.entitiesInit.Impl;

import com.ncTestService.dbInit.entitiesInit.ECTFInit;
import com.ncTestService.models.City;
import com.ncTestService.models.Enrollment;
import com.ncTestService.models.EnrollmentCityTestFormat;
import com.ncTestService.models.TestFormat;
import com.ncTestService.repositories.CityRepository;
import com.ncTestService.repositories.EnrollmentCityTestFormatRepository;
import com.ncTestService.repositories.EnrollmentRepository;
import com.ncTestService.repositories.TestFormatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ECTFInitImpl implements ECTFInit {

    @Autowired
    EnrollmentCityTestFormatRepository repository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    EnrollmentRepository enrollmentRepository;

    @Autowired
    TestFormatRepository testFormatRepository;


    @Override
    public void initECTF() {
        List<City> cities = (List)cityRepository.findAll();
        List<Enrollment> enrollments = (List)enrollmentRepository.findAll();
        List<TestFormat> testFormats = (List)testFormatRepository.findAll();

        for(City city : cities) {

            for(Enrollment enrollment : enrollments) {
                EnrollmentCityTestFormat ectf = new EnrollmentCityTestFormat(enrollment, city, testFormats.get(0));
                ectf.setActive(true);
                repository.save(ectf);

            }

        }


    }
}
