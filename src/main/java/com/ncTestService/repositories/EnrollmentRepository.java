package com.ncTestService.repositories;

import com.ncTestService.models.Enrollment;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface EnrollmentRepository extends CrudRepository<Enrollment, Long> {
    Enrollment findByAppStart(Date appStart);
}
