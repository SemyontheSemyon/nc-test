package com.ncTestService.services;


import com.ncTestService.models.*;
import org.springframework.ui.Model;

import java.util.List;

public interface TestService {

    Iterable<Test> getAllTests();
    Test getTest(Long id);
    void addTest(Test test);
    void updateTest(Test test);
    void deleteTest(Long id);
    void createTest(Long userId, TestFormat testFormat);

    Iterable<TestUser> getAllTestUsers();
    TestUser getTestUser(Long id);
    void addTestUser(TestUser testUser);
    void updateTestUser(TestUser testUser);
    void deleteTestUser(Long id);

    Iterable<TestFormat> getAllTestFormats();
    TestFormat getTestFormat(Long id);
    void addTestFormat(TestFormat testFormat);
    void updateTestFormat(TestFormat testFormat);
    void deleteTestFormat(Long id);

    List<Question> generateTest(int questionsNum);
    List<Question> generateTest(int questionsNum, String specialityName);
    boolean validateQuestion(String answer);
}
