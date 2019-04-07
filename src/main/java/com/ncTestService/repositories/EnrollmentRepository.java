package com.ncTestService.repositories;

import com.ncTestService.models.City;
import com.ncTestService.models.Enrollment;
import com.ncTestService.models.Speciality;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface EnrollmentRepository extends CrudRepository<Enrollment, Long> {
    Enrollment findByAppStartAndSpeciality(Date appStart, Speciality speciality);
    List<Enrollment> findBySpeciality(Speciality speciality);
    List<Enrollment> findByAppStart(Date appStart);
    List<Enrollment> findFirst5BySpecialityOrderByAppStartDesc(Speciality speciality);
}
