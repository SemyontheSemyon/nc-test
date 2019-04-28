package com.ncTestService.controllers;

import com.ncTestService.DTO.ECTFDTO;
import com.ncTestService.converters.ECTFConverter;
import com.ncTestService.models.EnrollmentCityTestFormat;
import com.ncTestService.services.CityService;
import com.ncTestService.services.ECTFService;
import com.ncTestService.services.EnrollmentService;
import com.ncTestService.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class EnrollmentController {

    @Autowired
    ECTFService ectfService;

    @Autowired
    EnrollmentService enrollmentService;

    @Autowired
    TestService testService;

    @Autowired
    CityService cityService;

    @Autowired
    ECTFConverter ectfConverter;

    @GetMapping("/api/enrollment/active")
    List<ECTFDTO> getActive() {

        List<EnrollmentCityTestFormat> list = ectfService.getActiveECTF();

        List<ECTFDTO> DTOList = new ArrayList<>();

        for (EnrollmentCityTestFormat ectf : list) {
            DTOList.add(ectfConverter.convertToDTO(ectf));
        }

        return DTOList;
    }

    @PostMapping("/api/enrollment/new")
    ResponseEntity addEnrollment(@RequestBody ECTFDTO dto) {

        EnrollmentCityTestFormat ectf = ectfConverter.convertFromDTO(dto);

        ectf.setEnrollment(enrollmentService.addEnrollment(ectf.getEnrollment()));
        ectf.setTestFormat(testService.addTestFormat(ectf.getTestFormat()));

        ectfService.addECTF(ectf);

        return ResponseEntity.ok(HttpStatus.OK);

    }

    @GetMapping("/api/cities")
    ResponseEntity<?> getCities() {
        return ResponseEntity.ok(cityService.findAllNames());
    }

}
