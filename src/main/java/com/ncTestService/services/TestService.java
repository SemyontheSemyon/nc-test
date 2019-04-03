package com.ncTestService.services;


import com.ncTestService.models.*;
import org.springframework.ui.Model;

import java.util.List;

public interface TestService {

    List<Test> getAllTests();
    Test getTest(Long id);
    void addTest(Test test);
    void updateTest(Test test);
    void deleteTest(Test test);

    List<TestUser> getAllTestUsers();
    TestUser getTestUser(Long id);
    void addTestUser(TestUser testUser);
    void updateTestUser(TestUser testUser);
    void deleteTestUser(TestUser testUser);

    List<TestFormat> getAllTestFormats();
    TestFormat getTestFormat(Long id);
    void addTestFormat(TestFormat testFormat);
    void updateTestFormat(TestFormat testFormat);
    void deleteTestFormat(TestFormat testFormat);

    List<Question> generateTest(int questionsNum);
    void validateQuestion(Question question, String answer);
}
