package com.ncTestService.dailyRoutine;

import com.ncTestService.models.EnrollmentCityTestFormat;
import com.ncTestService.services.ECTFService;
import com.ncTestService.services.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class EnrollmentChecker {

    @Autowired
    EnrollmentService enrollmentService;

    @Autowired
    ECTFService ectfService;

    @Scheduled(fixedRate = (1000*60*60*24))
    public void checkEnrollments() {

        List<EnrollmentCityTestFormat> list = ectfService.getActiveECTF();

        Date now = new Date();

        for(EnrollmentCityTestFormat ectf : list) {

            ectf.setActive(ectf.getEnrollment().getAppEnd().after(now));

        }

    }

}
