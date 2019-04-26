package com.ncTestService.controllers;

import com.ncTestService.DTO.AnswerDTO;
import com.ncTestService.DTO.QuestionDTO;
import com.ncTestService.converters.Impl.AnswerConv;
import com.ncTestService.converters.Impl.QuestionConv;
import com.ncTestService.models.*;
import com.ncTestService.repositories.QuestionRepository;
import com.ncTestService.services.TestService;
import com.ncTestService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TestController {

    @Autowired
    UserService userService;

    @Autowired
    TestService testService;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    QuestionConv questionConv;

    @Autowired
    AnswerConv answerConv;


    @GetMapping("/api/test/questions")
    public ResponseEntity getQuestions() {

        User user = userService.getPrincipialUser();

        EnrollmentCityTestFormat ectf = userService.getUserInfoByUserId(user.getId()).get().getEnrollment();

        TestFormat testFormat = ectf.getTestFormat();
        Speciality speciality = ectf.getEnrollment().getSpeciality();

        List<Question> questions = testService.generateTest(testFormat.getNumberOfQuestions(), speciality);

        List<QuestionDTO> questionDTOList = new ArrayList<>();

        for(Question question : questions) {
            questionDTOList.add(questionConv.convertToDTO(question));
        }

        return new ResponseEntity(questionDTOList, HttpStatus.OK);

    }

    @PostMapping("/api/test/")
    public ResponseEntity endTest(@RequestBody List<AnswerDTO> answers) {

        User user = userService.getPrincipialUser();
        TestFormat testFormat = userService
                .getUserInfoByUserId(user.getId())
                .get()
                .getEnrollment()
                .getTestFormat();

        Test test = new Test();
        test.setUser(user);
        test.setTakenAt(new Date());
        test.setPassed(false);

        testService.addTest(test);

        List<TestUser> testUsers = new ArrayList<>();

        for(AnswerDTO dto : answers) {
            TestUser testUser = answerConv.convertFromDTO(dto);
            testUser.setTest(test);
            testService.checkTestUser(testUser);
            testUsers.add(testUser);
            testService.addTestUser(testUser);
        }

        testService.checkTest(testUsers, test, testFormat);
        testService.updateTest(test);

        return ResponseEntity.ok(HttpStatus.OK);

    }

}
