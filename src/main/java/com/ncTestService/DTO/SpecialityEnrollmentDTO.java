package com.ncTestService.DTO;

import com.ncTestService.models.Enrollment;
import com.ncTestService.models.Speciality;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpecialityEnrollmentDTO {

    private Speciality speciality;

    private List<Enrollment> enrollmentList;

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public List<Enrollment> getEnrollmentList() {
        return enrollmentList;
    }

    public void setEnrollmentList(List<Enrollment> enrollmentList) {
        this.enrollmentList = enrollmentList;
    }

    private SpecialityEnrollmentDTO() {
    }

    public SpecialityEnrollmentDTO(Speciality speciality) {
        this.speciality = speciality;
    }
}
