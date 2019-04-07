package com.ncTestService.controllers;

import com.ncTestService.models.AnswerType;
import com.ncTestService.models.Question;
import com.ncTestService.models.TestFormat;
import com.ncTestService.models.UserInfo;
import com.ncTestService.repositories.AnswerTypeRepository;
import com.ncTestService.services.TestService;
import com.ncTestService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;

    @Autowired
    UserService userService;

    @GetMapping
    public List<Question> getQuestions(@RequestParam(name = "specialityName") String specialityName,
                                       @RequestParam(name = "userId") Long userId) {


        UserInfo userInfo = userService.getUserInfoByUserId(userId);

        TestFormat testFormat = userInfo.getEnrollment().getTestFormat();

        List<Question> questionList = testService.generateTest(testFormat.getNumberOfQuestions(), specialityName);

        testService.createTest(userId, testFormat);

        return questionList;

    }

    @PostMapping
    public ResponseEntity createTestUsers(@RequestBody List<Question> questions) {





        return ResponseEntity.ok(HttpStatus.OK);

    }


    //узнать про GET /test/finished

}
