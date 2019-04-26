package com.ncTestService.dbInit.entitiesInit.Impl;

import com.ncTestService.dbInit.entitiesInit.EnrollmentInit;
import com.ncTestService.models.Enrollment;
import com.ncTestService.models.Speciality;
import com.ncTestService.repositories.EnrollmentRepository;
import com.ncTestService.repositories.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class EnrollmentInitImpl implements EnrollmentInit {

    @Autowired
    EnrollmentRepository enrollmentRepository;

    @Autowired
    SpecialityRepository specialityRepository;

    @Override
    public void initEnrollments() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");

        String jan = "15-01-2019";
        String feb = "15-02-2019";
        String march = "15-03-2019";
        String april = "15-04-2019";
        String may = "15-05-2019";
        String june = "15-06-2019";

        String[] months = {jan, feb, march, april, may, june};

        List<Speciality> specialities = (List)specialityRepository.findAll();



        System.out.println("ENROLLMENT");

        for(int i = 0; i<specialities.size(); i++) {

            Enrollment enrollment = new Enrollment();
            
            enrollment.setAppStart(months[i]);
            enrollment.setAppEnd(months[i+1]);
            enrollment.setTestStart(months[i+2]);
            enrollment.setTestEnd(months[i+3]);
            enrollment.setSpeciality(specialities.get(i));
            enrollmentRepository.save(enrollment);

        }

    }
}
