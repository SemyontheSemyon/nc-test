package com.ncTestService.services.interfaces;

import com.ncTestService.models.City;
import com.ncTestService.models.Enrollment;
import com.ncTestService.models.Speciality;
import com.ncTestService.models.User;

import java.util.Date;
import java.util.List;

public interface EnrollmentService {

    Iterable<Enrollment> getAllEnrollments();
    Enrollment getEnrollment(Long id);
    void addEnrollment(Enrollment enrollment);
    void updateEnrollment(Enrollment enrollment);
    void deleteEnrollment(Long id);


    List<Enrollment> findByAppStart(Date appStart);
    List<Enrollment> findBySpeciality(String speciality);
    List<Enrollment> findFirstFive(Speciality speciality);

    List<City> findByCountry(String name);
}
