package com.ncTestService.services.interfaces;

import com.ncTestService.models.Speciality;

public interface SpecialityService {

    Iterable<Speciality> getAll();
    Speciality getSpeciality(Long id);
    Speciality getSpeciality(String name);
    void addSpeciality(Speciality speciality);
    void updateSpeciality(Speciality speciality);

}
