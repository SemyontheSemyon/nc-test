package com.ncTestService.converters.Impl;

import com.ncTestService.DTO.SpecialityDTO;
import com.ncTestService.models.Speciality;
import org.springframework.stereotype.Service;

@Service
public class SpecialityConv {

    public SpecialityDTO convertToDTO(Speciality speciality) {

        SpecialityDTO dto = new SpecialityDTO();

        dto.setId(speciality.getId());
        dto.setName(speciality.getName());
        dto.setShortDescription(speciality.getDescription().substring(0, 250) + "...");
        dto.setFullDescription(speciality.getDescription());

        return dto;
    }

}
