package com.ncTestService.converters.Impl;

import com.ncTestService.DTO.ECTFDTO;
import com.ncTestService.converters.ECTFConverter;
import com.ncTestService.models.*;
import com.ncTestService.services.CityService;
import com.ncTestService.services.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ECTFConverterImpl implements ECTFConverter {

    @Autowired
    CityService cityService;

    @Autowired
    SpecialityService specialityService;

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

        return ectfdto;
    }

    @Override
    public EnrollmentCityTestFormat convertFromDTO(ECTFDTO ectfdto) {

        Speciality speciality = specialityService.getSpeciality(ectfdto.getSpeciality());
        Enrollment enrollment = new Enrollment(
                speciality,
                ectfdto.getAppStart(),
                ectfdto.getAppEnd(),
                ectfdto.getTestStart(),
                ectfdto.getTestEnd(),
                ectfdto.getCreatedAt());
        City city = cityService.findByName(ectfdto.getCity());
        TestFormat testFormat = new TestFormat(
                ectfdto.getTime(),
                ectfdto.getNumberOfQuestions());

        EnrollmentCityTestFormat ectf = new EnrollmentCityTestFormat(enrollment, city, testFormat);


        return ectf;
    }
}
