package com.ncTestService.services;

import com.ncTestService.models.*;
import com.ncTestService.repositories.*;
import com.ncTestService.services.interfaces.TestService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    TestRepository testRepository;
    TestUserRepository testUserRepository;
    TestFormatRepository testFormatRepository;
    QuestionRepository questionRepository;
    AnswerRepository answerRepository;
    SpecialityRepository specialityRepository;
    UserRepository userRepository;

    @Override
    public Iterable<Test> getAllTests() {
        return testRepository.findAll();
    }

    @Override
    public Test getTest(Long id) {
        return testRepository.findById(id).get();
    }

    @Override
    public Test getTestByUserId(Long userId) {
        User user = userRepository.findById(userId).get();

        return testRepository.findByUser(user);

    }

    @Override
    public void addTest(Test test) {
        testRepository.save(test);
    }

    @Override
    public void updateTest(Test test) {
        testRepository.save(test);
    }

    @Override
    public void deleteTest(Long id) {
        testRepository.deleteById(id);
    }

    @Override
    public void createTest(Long userId, TestFormat testFormat) {
        User user = userRepository.findById(userId).get();
        Date date = new Date();

        Test test = new Test();
        test.setTakenAt(date);
        test.setPassed(false);
        test.setTestFormat(testFormat);
        test.setUser(user);

        testRepository.save(test);
    }

    @Override
    public Iterable<TestUser> getAllTestUsers() {
        return testUserRepository.findAll();
    }

    @Override
    public TestUser getTestUser(Long id) {
        return testUserRepository.findById(id).get();
    }

    @Override
    public void addTestUser(TestUser testUser) {
        testUserRepository.save(testUser);
    }

    @Override
    public void updateTestUser(TestUser testUser) {
        testUserRepository.save(testUser);
    }

    @Override
    public void deleteTestUser(Long id) {
        testUserRepository.deleteById(id);
    }

    @Override
    public Iterable<TestFormat> getAllTestFormats() {
        return testFormatRepository.findAll();
    }

    @Override
    public TestFormat getTestFormat(Long id) {
        return testFormatRepository.findById(id).get();
    }

    @Override
    public void addTestFormat(TestFormat testFormat) {
        testFormatRepository.save(testFormat);
    }

    @Override
    public void updateTestFormat(TestFormat testFormat) {
        testFormatRepository.save(testFormat);
    }

    @Override
    public void deleteTestFormat(Long id) {
        testFormatRepository.deleteById(id);
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

    @Override
    public List<Question> generateTest(int questionsNum, String specialityName) {

        Speciality speciality = specialityRepository.findByName(specialityName);
        List<Question> questionList = questionRepository.findBySpeciality(speciality);
        List<Question> testList = new ArrayList<>();

        for(int i = 0; i<questionsNum; i++) {

            Question q = questionList.get((int)(Math.random() * questionList.size()) + 1);
            testList.add(q);
            questionList.remove(q);
        }

        return testList;

    }

    public boolean validateQuestion(String answer){
        return answerRepository.findByText(answer).isCorrect();
    }
}
