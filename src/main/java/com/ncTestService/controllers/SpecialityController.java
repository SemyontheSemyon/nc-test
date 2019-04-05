package com.ncTestService.controllers;


import com.ncTestService.DTO.SpecialityEnrollmentDTO;
import com.ncTestService.models.Enrollment;
import com.ncTestService.models.Question;
import com.ncTestService.models.User;
import com.ncTestService.models.UserInfo;
import com.ncTestService.services.EnrollmentService;
import com.ncTestService.services.SpecialityEnrollmentDTOService;
import com.ncTestService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/speciality")
public class SpecialityController {

    @Autowired
    SpecialityEnrollmentDTOService specialityEnrollmentDTOService;

    @Autowired
    UserService userService;

    @Autowired
    EnrollmentService enrollmentService;

    @GetMapping("/{specialityName}")
    public SpecialityEnrollmentDTO getSpecialityAndEnrollments(@PathVariable String specialityName) {


        return specialityEnrollmentDTOService.getSpecialityEnrollmentDTO(specialityName);


    }

    @PostMapping("/{specialityName}/{enrollmentId}")
    public ResponseEntity addEnrollment(@RequestBody User user, @PathVariable Long enrollmentId) {

        Enrollment enrollment = enrollmentService.getEnrollment(enrollmentId);

        UserInfo userInfo = userService.getUserInfo(user);

        //implement

        return ResponseEntity.ok(HttpStatus.OK);

    }

    @GetMapping("/{specialityName}/questions")
    public List<Question> getQuestions(@PathVariable String specialityName) {

        //implement

        return new ArrayList<>();

    }

}
