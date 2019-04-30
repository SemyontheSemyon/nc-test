package com.ncTestService.controllers;

import com.ncTestService.DTO.SpecialityDTO;
import com.ncTestService.converters.Impl.SpecialityConv;
import com.ncTestService.models.Speciality;
import com.ncTestService.services.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController()
public class SpecialityController {

    @Autowired
    SpecialityService specialityService;

    @Autowired
    SpecialityConv specialityConv;

    @GetMapping("/api/specialities/all")
    public List<SpecialityDTO> home()
    {
        List<Speciality> specialities = (List)specialityService.getAll();
        List<SpecialityDTO> dtos = new ArrayList<>();

        for(Speciality speciality : specialities) dtos.add(specialityConv.convertToDTO(speciality));

        return dtos;
    }

    @GetMapping("/api/specialities/{id}")
    public SpecialityDTO getSpeciality(@PathVariable("id") Long id) {
        Speciality speciality = specialityService.getSpeciality(id);

        return specialityConv.convertToDTO(speciality);
    }

}
