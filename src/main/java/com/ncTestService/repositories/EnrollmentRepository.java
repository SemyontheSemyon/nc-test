package com.ncTestService.repositories;

import com.ncTestService.models.Enrollment;
import org.springframework.data.repository.CrudRepository;

public interface EnrollmentRepository extends CrudRepository<Enrollment, Long> {
}
