package com.ncTestService.services;

import com.ncTestService.models.City;
import com.ncTestService.models.Enrollment;
import com.ncTestService.models.Speciality;
import com.ncTestService.models.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.Date;
import java.util.List;

public interface EnrollmentService {

    Iterable<Enrollment> getAllEnrollments();
    Enrollment getEnrollment(Long id);
    Enrollment addEnrollment(Enrollment enrollment);
    Enrollment updateEnrollment(Enrollment enrollment);
    void deleteEnrollment(Long id);


    List<Enrollment> findByAppStart(Date appStart);
    List<Enrollment> findBySpeciality(String speciality);
    List<Enrollment> findFirstFive(Speciality speciality);

}
