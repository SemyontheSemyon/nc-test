package com.ncTestService.controllers;

import com.ncTestService.DTO.AnswersQuestionsDTO;
import com.ncTestService.DTO.TestUserDTO;
import com.ncTestService.models.*;
import com.ncTestService.services.interfaces.AnswersQuestionsDTOService;
import com.ncTestService.services.interfaces.TestService;
import com.ncTestService.services.interfaces.TestUserDTOService;
import com.ncTestService.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;

    @Autowired
    UserService userService;

    @Autowired
    AnswersQuestionsDTOService answersQuestionsDTOService;

    @Autowired
    TestUserDTOService testUserDTOService;

    @GetMapping
    public AnswersQuestionsDTO getQuestions(@RequestParam(name = "specialityName") String specialityName,
                                       @RequestParam(name = "userId") Long userId) {


        UserInfo userInfo = userService.getUserInfoByUserId(userId);

        TestFormat testFormat = userInfo.getEnrollment().getTestFormat();

        List<Question> questionList = testService.generateTest(testFormat.getNumberOfQuestions(), specialityName);

        AnswersQuestionsDTO dto = answersQuestionsDTOService.createDTO(questionList);

        testService.createTest(userId, testFormat);

        return dto;

    }

    @PostMapping
    public ResponseEntity createTestUsers(@RequestBody TestUserDTO dto) {

        List<TestUser> testUserList = testUserDTOService.makeTestUsers(dto);

        for(TestUser testUser : testUserList) {
            testService.addTestUser(testUser);
        }

        return ResponseEntity.ok(HttpStatus.OK);

    }


    //узнать про GET /test/finished

}
