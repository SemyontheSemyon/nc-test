package com.ncTestService.services;

import com.ncTestService.models.Question;
import com.ncTestService.models.Test;
import com.ncTestService.models.TestFormat;
import com.ncTestService.models.TestUser;
import com.ncTestService.repositories.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    TestRepository testRepository;
    TestUserRepository testUserRepository;
    TestFormatRepository testFormatRepository;
    QuestionRepository questionRepository;
    AnswerRepository answerRepository;

    @Override
    public List<Test> getAllTests() {
        return null;
    }

    @Override
    public Test getTest(Long id) {
        return null;
    }

    @Override
    public void addTest(Test test) {

    }

    @Override
    public void updateTest(Test test) {

    }

    @Override
    public void deleteTest(Test test) {

    }

    @Override
    public List<TestUser> getAllTestUsers() {
        return null;
    }

    @Override
    public TestUser getTestUser(Long id) {
        return null;
    }

    @Override
    public void addTestUser(TestUser testUser) {

    }

    @Override
    public void updateTestUser(TestUser testUser) {

    }

    @Override
    public void deleteTestUser(TestUser testUser) {

    }

    @Override
    public List<TestFormat> getAllTestFormats() {
        return null;
    }

    @Override
    public TestFormat getTestFormat(Long id) {
        return null;
    }

    @Override
    public void addTestFormat(TestFormat testFormat) {

    }

    @Override
    public void updateTestFormat(TestFormat testFormat) {

    }

    @Override
    public void deleteTestFormat(TestFormat testFormat) {

    }

    @Override
    public List<Question> generateTest(int questionsNum) {
        Long qty = questionRepository.count();
        List<Question> testQuestions = new ArrayList();
        Long idx = Long.valueOf((long) (Math.random() * qty) + 1);

        for (int i = 0; i < questionsNum; i++) {
            testQuestions.add(questionRepository.findById(idx).get());
            idx = Long.valueOf((long) (Math.random() * qty) + 1);
        }

        return testQuestions;
    }

    void validateQuestion(Question question, String answer){

    }
}
