package com.ncTestService.services.impl;


import com.ncTestService.models.Enrollment;
import com.ncTestService.repositories.EnrollmentRepository;
import com.ncTestService.services.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    private EnrollmentRepository enrollmentRepository;

    @Autowired
    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    @Override
    public Enrollment addEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

}
