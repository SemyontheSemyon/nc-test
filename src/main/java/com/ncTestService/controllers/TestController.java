package com.ncTestService.controllers;

import com.ncTestService.DTO.AnswerDTO;
import com.ncTestService.DTO.QuestionDTO;
import com.ncTestService.converters.Impl.AnswerConv;
import com.ncTestService.converters.Impl.QuestionConv;
import com.ncTestService.models.*;
import com.ncTestService.services.TestService;
import com.ncTestService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TestController {

    private UserService userService;
    private TestService testService;
    private QuestionConv questionConv;
    private AnswerConv answerConv;

    @Autowired
    public TestController(UserService userService, TestService testService, QuestionConv questionConv, AnswerConv answerConv) {
        this.userService = userService;
        this.testService = testService;
        this.questionConv = questionConv;
        this.answerConv = answerConv;
    }

    @GetMapping("api/test")
    public ResponseEntity getTestFormat() {

        User user = userService.getPrincipialUser();

        Optional<UserInfo> optUserInfo = userService.getUserInfoByUserId(user.getId());
        UserInfo userInfo = optUserInfo.orElseGet(UserInfo::new);
        EnrollmentCityTestFormat ectf = userInfo.getEnrollment();

        TestFormat testFormat;

        if (ectf != null) {
            testFormat = ectf.getTestFormat();
        } else return new ResponseEntity("Apply on enrollment first!", HttpStatus.CONFLICT);

        return new ResponseEntity(testFormat, HttpStatus.OK);

    }

    @GetMapping("/api/test/questions")
    public ResponseEntity getQuestions() {

        User user = userService.getPrincipialUser();

        Optional<UserInfo> optUserInfo = userService.getUserInfoByUserId(user.getId());
        UserInfo userInfo = optUserInfo.orElseGet(UserInfo::new);
        EnrollmentCityTestFormat ectf = userInfo.getEnrollment();

        TestFormat testFormat;
        Speciality speciality;

        if (ectf != null) {
            testFormat = ectf.getTestFormat();
            speciality = ectf.getEnrollment().getSpeciality();
        } else return new ResponseEntity("Apply on enrollment first!", HttpStatus.CONFLICT);

        List<Question> questions = testService.generateTest(testFormat.getNumberOfQuestions(), speciality);

        List<QuestionDTO> questionDTOList = new ArrayList<>();

        for (Question question : questions) {
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

        for (AnswerDTO dto : answers) {
            TestUser testUser = answerConv.convertFromDTO(dto);
            testUser.setTest(test);
            testUser.setCorrect(testService.checkAnswers(dto));
            testUsers.add(testUser);
            testService.addTestUser(testUser);
        }

        testService.checkTest(testUsers, test, testFormat);
        testService.updateTest(test);

        return ResponseEntity.ok(HttpStatus.OK);

    }

}
