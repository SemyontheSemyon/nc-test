package com.ncTestService.services;

import com.ncTestService.models.Speciality;
import com.ncTestService.repositories.SpecialityRepository;
import com.ncTestService.services.interfaces.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecialityServiceImpl implements SpecialityService {

    @Autowired
    SpecialityRepository specialityRepository;

    @Override
    public Iterable<Speciality> getAll() {
        return specialityRepository.findAll();
    }

    @Override
    public Speciality getSpeciality(Long id) {
        return specialityRepository.findById(id).get();
    }

    @Override
    public Speciality getSpeciality(String name) {
        return specialityRepository.findByName(name);
    }

    @Override
    public void addSpeciality(Speciality speciality) {
        specialityRepository.save(speciality);
    }

    @Override
    public void updateSpeciality(Speciality speciality) {
        specialityRepository.save(speciality);
    }
}
