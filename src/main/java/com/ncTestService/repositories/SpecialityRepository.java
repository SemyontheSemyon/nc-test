package com.ncTestService.repositories;

import com.ncTestService.models.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
    Speciality findByName(String name);
}
