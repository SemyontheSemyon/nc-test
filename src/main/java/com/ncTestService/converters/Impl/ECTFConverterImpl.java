package com.ncTestService.converters.Impl;

import com.ncTestService.DTO.ECTFDTO;
import com.ncTestService.converters.ECTFConverter;
import com.ncTestService.models.*;
import com.ncTestService.repositories.EnrollmentCityTestFormatRepository;
import com.ncTestService.services.CityService;
import com.ncTestService.services.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ECTFConverterImpl implements ECTFConverter {

    private CityService cityService;
    private SpecialityService specialityService;
    private EnrollmentCityTestFormatRepository ectfRepository;

    @Autowired
    public ECTFConverterImpl(CityService cityService, SpecialityService specialityService, EnrollmentCityTestFormatRepository ectfRepository) {
        this.cityService = cityService;
        this.specialityService = specialityService;
        this.ectfRepository = ectfRepository;
    }

    @Override
    public ECTFDTO convertToDTO(EnrollmentCityTestFormat ectf) {

        ECTFDTO ectfdto = new ECTFDTO();
        Enrollment enrollment = ectf.getEnrollment();
        City city = ectf.getCity();
        Speciality speciality = enrollment.getSpeciality();
        TestFormat testFormat = ectf.getTestFormat();

        ectfdto.setId(ectf.getId());
        ectfdto.setCity(city.getName());
        ectfdto.setSpeciality(speciality.getName());
        ectfdto.setAppStart(enrollment.getAppStart());
        ectfdto.setAppEnd(enrollment.getAppEnd());
        ectfdto.setTestStart(enrollment.getTestStart());
        ectfdto.setTestEnd(enrollment.getTestEnd());
        ectfdto.setCreatedAt(enrollment.getCreatedAt());
        ectfdto.setNumberOfQuestions(testFormat.getNumberOfQuestions());
        ectfdto.setTime(testFormat.getTime());
        ectfdto.setThreshold(testFormat.getThreshold());

        return ectfdto;
    }

    @Override
    public EnrollmentCityTestFormat convertFromDTO(ECTFDTO ectfdto) {

        EnrollmentCityTestFormat ectf;
        Enrollment enrollment;
        TestFormat testFormat;

        if (ectfdto.getId() != null) {
            ectf = ectfRepository.findById(ectfdto.getId()).get();
            enrollment = ectf.getEnrollment();
            testFormat = ectf.getTestFormat();
        } else {
            ectf = new EnrollmentCityTestFormat();
            enrollment = new Enrollment();
            City city = cityService.findByName(ectfdto.getCity());
            testFormat = new TestFormat();
            Speciality speciality = specialityService.getSpeciality(ectfdto.getSpeciality());

            ectf.setCity(city);
            ectf.setEnrollment(enrollment);
            ectf.setTestFormat(testFormat);
            enrollment.setSpeciality(speciality);
        }

        enrollment.setAppStart(ectfdto.getAppStart());
        enrollment.setAppEnd(ectfdto.getAppEnd());
        enrollment.setTestStart(ectfdto.getTestStart());
        enrollment.setTestEnd(ectfdto.getTestEnd());

        testFormat.setTime(ectfdto.getTime());
        testFormat.setNumberOfQuestions(ectfdto.getNumberOfQuestions());
        testFormat.setThreshold(ectfdto.getThreshold());

        return ectf;
    }
}
