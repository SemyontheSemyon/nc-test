package com.ncTestService.services.impl;


import com.ncTestService.models.City;
import com.ncTestService.models.Enrollment;
import com.ncTestService.models.Speciality;
import com.ncTestService.repositories.CityRepository;
import com.ncTestService.repositories.CountryRepository;
import com.ncTestService.repositories.EnrollmentRepository;
import com.ncTestService.repositories.SpecialityRepository;
import com.ncTestService.services.EnrollmentService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    EnrollmentRepository enrollmentRepository;
    CityRepository cityRepository;
    CountryRepository countryRepository;
    SpecialityRepository specialityRepository;

    @Override
    public Iterable<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    @Override
    public Enrollment getEnrollment(Long id) {
        return enrollmentRepository.findById(id).get();
    }

    @Override
    public Enrollment addEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public Enrollment updateEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public void deleteEnrollment(Long id) {
        enrollmentRepository.deleteById(id);
    }


    @Override
    public List<Enrollment> findBySpeciality(String speciality) {
        return enrollmentRepository.findBySpeciality(specialityRepository.findByName(speciality));
    }

    @Override
    public List<Enrollment> findFirstFive(Speciality speciality) {
        return enrollmentRepository.findFirst5BySpecialityOrderByAppStartDesc(speciality);
    }
}
