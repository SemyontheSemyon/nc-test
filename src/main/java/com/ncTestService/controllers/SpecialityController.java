package com.ncTestService.controllers;

import com.ncTestService.models.Speciality;
import com.ncTestService.services.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController()
public class SpecialityController {

    @Autowired
    private SpecialityService specialityService;

    @GetMapping("/api/speciality/all")
    public ResponseEntity<?> getSpecialities() {
        return ResponseEntity.ok(specialityService.getAll());
    }

    @GetMapping("/api/speciality/{name}")
    public Speciality getSpeciality(@PathVariable("name") String name) {
        return specialityService.getSpeciality(name);
    }

}
