package com.ncTestService.services;


import com.ncTestService.DTO.AnswerDTO;
import com.ncTestService.models.*;

import java.util.List;

public interface TestService {

    void addTest(Test test);

    void updateTest(Test test);

    void checkTest(List<TestUser> testUsers, Test test, TestFormat testFormat);

    void addTestUser(TestUser testUser);

    boolean checkAnswers(AnswerDTO dto);

    TestFormat addTestFormat(TestFormat testFormat);

    List<Question> generateTest(int questionsNum, Speciality speciality);

}
