package com.ncTestService.services;

import com.ncTestService.models.Speciality;

public interface SpecialityService {

    Iterable<Speciality> getAll();

    Speciality getSpeciality(Long id);

    Speciality getSpeciality(String name);

}
