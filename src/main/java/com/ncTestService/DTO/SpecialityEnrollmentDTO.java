package com.ncTestService.DTO;

import com.ncTestService.models.Enrollment;
import com.ncTestService.models.Speciality;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class SpecialityEnrollmentDTO {

    private Speciality speciality;

    private List<Enrollment> enrollmentList;


}
