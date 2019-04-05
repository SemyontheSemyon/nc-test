package com.ncTestService.services;

import com.ncTestService.DTO.SpecialityEnrollmentDTO;
import org.springframework.stereotype.Service;

public interface SpecialityEnrollmentDTOService {

    SpecialityEnrollmentDTO getSpecialityEnrollmentDTO(String specialityName);

}
