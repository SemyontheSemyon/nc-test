package com.ncTestService.services;

import com.ncTestService.DTO.SpecialityEnrollmentDTO;
import com.ncTestService.models.Enrollment;
import com.ncTestService.models.Speciality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialityEnrollmentDTOServiceImpl implements SpecialityEnrollmentDTOService {

    @Autowired
    SpecialityService specialityService;

    @Autowired
    EnrollmentService enrollmentService;


    private void setEnrollments(SpecialityEnrollmentDTO dto, Speciality speciality) {

        List<Enrollment> enrollmentList = enrollmentService.findFirstFive(speciality);

        dto.setEnrollmentList(enrollmentList);

    }

    @Override
    public SpecialityEnrollmentDTO getSpecialityEnrollmentDTO(String specialityName) {

        Speciality speciality = specialityService.getSpeciality(specialityName);

        SpecialityEnrollmentDTO specialityEnrollmentDTO = new SpecialityEnrollmentDTO(speciality);

        this.setEnrollments(specialityEnrollmentDTO, speciality);

        return specialityEnrollmentDTO;
    }
}
