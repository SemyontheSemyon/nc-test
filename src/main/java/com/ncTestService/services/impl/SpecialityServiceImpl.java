package com.ncTestService.services.impl;

import com.ncTestService.models.Speciality;
import com.ncTestService.repositories.SpecialityRepository;
import com.ncTestService.services.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecialityServiceImpl implements SpecialityService {

    private SpecialityRepository specialityRepository;

    @Autowired
    public SpecialityServiceImpl(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

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

}
