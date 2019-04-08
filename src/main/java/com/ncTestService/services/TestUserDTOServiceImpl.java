package com.ncTestService.services;

import com.ncTestService.DTO.TestUserDTO;
import com.ncTestService.models.Answer;
import com.ncTestService.models.Question;
import com.ncTestService.models.Test;
import com.ncTestService.models.TestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestUserDTOServiceImpl implements TestUserDTOService {


    @Autowired
    TestService testService;

    @Autowired
    AnswerService answerService;

    @Override
    public List<TestUser> makeTestUsers(TestUserDTO dto) {

        Test test = testService.getTestByUserId(dto.getUserId());

        List<TestUser> testUserList = new ArrayList<>();

        for(Question q : dto.getQuestionAnswerMap().keySet()) {

            Answer answer = answerService.getCorrectAnswer(q);

            String studentAnswer = dto.getQuestionAnswerMap().get(q);

            TestUser testUser = new TestUser();
            testUser.setAnswer(answer);
            testUser.setCorrect(false);
            testUser.setQuestion(q);
            testUser.setStudentAnswer(studentAnswer);
            testUser.setTest(test);

            testUserList.add(testUser);
        }

        return testUserList;



    }
}
