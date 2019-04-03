package com.ncTestService.services;


import com.ncTestService.models.City;
import com.ncTestService.models.Enrollment;
import com.ncTestService.models.User;
import com.ncTestService.repositories.CityRepository;
import com.ncTestService.repositories.CountryRepository;
import com.ncTestService.repositories.EnrollmentRepository;
import com.ncTestService.repositories.SpecialityRepository;
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
    public void addEnrollment(Enrollment enrollment) {
        enrollmentRepository.save(enrollment);
    }

    @Override
    public void updateEnrollment(Enrollment enrollment) {
        enrollmentRepository.save(enrollment);
    }

    @Override
    public void deleteEnrollment(Long id) {
        enrollmentRepository.deleteById(id);
    }

    @Override
    public List<Enrollment> findByAppStart(Date appStart) {
        return enrollmentRepository.findByAppStart(appStart);
    }

    @Override
    public List<Enrollment> findBySpeciality(String speciality) {
        return enrollmentRepository.findBySpeciality(specialityRepository.findByName(speciality));
    }

    @Override
    public List<Enrollment> findByCity(String city) {
        return enrollmentRepository.findByCity(cityRepository.findByName(city));
    }

    @Override
    public List<City> findByCountry(String name) {
        return cityRepository.findByCountry(countryRepository.findByName(name));
    }
}
