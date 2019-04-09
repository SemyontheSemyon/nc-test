package com.ncTestService.controllers;


import com.ncTestService.DTO.SpecialityEnrollmentDTO;
import com.ncTestService.models.*;
import com.ncTestService.services.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/speciality")
public class SpecialityController {

    @Autowired
    SpecialityEnrollmentDTOService specialityEnrollmentDTOService;

    @Autowired
    UserService userService;

    @Autowired
    ECTFService ectfService;

    @Autowired
    QuestionService questionService;

    @GetMapping("/{specialityName}")
    public SpecialityEnrollmentDTO getSpecialityAndEnrollments(@PathVariable String specialityName) {


        return specialityEnrollmentDTOService.getSpecialityEnrollmentDTO(specialityName);


    }

    @PostMapping("/{specialityName}/{enrollmentId}")
    public ResponseEntity addEnrollment(@RequestBody User user, @PathVariable Long enrollmentId) {

        EnrollmentCityTestFormat enrollment = ectfService.getECTF(enrollmentId);

        UserInfo userInfo = userService.getUserInfo(user);

        userInfo.setEnrollment(enrollment);

        userService.updateUserInfo(userInfo);

        return ResponseEntity.ok(HttpStatus.OK);

    }

    @GetMapping("/{specialityName}/questions")
    public List<Question> getQuestions(@PathVariable String specialityName) {

        List<Question> questionList = questionService.getQuestions(specialityName);

        return questionList;

    }

}
