package com.ncTestService.controllers;

import com.ncTestService.models.Speciality;
import com.ncTestService.services.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class SpecialityController {

    @Autowired
    SpecialityService specialityService;

    @GetMapping("/api/specialities/all")
    public List<Speciality> home() {
        return (List)specialityService.getAll();
    }

    @GetMapping("/api/specialities/{id}")
    public Speciality getSpeciality(@PathVariable("id") Long id) {
        return specialityService.getSpeciality(id);
    }

}
