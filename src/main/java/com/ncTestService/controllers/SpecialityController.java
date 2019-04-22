package com.ncTestService.controllers;

import com.ncTestService.models.Speciality;
import com.ncTestService.services.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("speciality")
public class SpecialityController {

    @Autowired
    SpecialityService specialityService;

    @GetMapping("/specialities")
    List<Speciality> getSpecialities() {
        return (List)specialityService.getAll();
    }

}
