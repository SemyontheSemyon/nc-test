package com.ncTestService.services.impl;

import com.ncTestService.models.*;
import com.ncTestService.repositories.QuestionRepository;
import com.ncTestService.repositories.TestFormatRepository;
import com.ncTestService.repositories.TestRepository;
import com.ncTestService.repositories.TestUserRepository;
import com.ncTestService.services.TestService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    private TestRepository testRepository;
    private TestUserRepository testUserRepository;
    private TestFormatRepository testFormatRepository;
    private QuestionRepository questionRepository;

    public TestServiceImpl(TestRepository testRepository, TestUserRepository testUserRepository, TestFormatRepository testFormatRepository, QuestionRepository questionRepository) {
        this.testRepository = testRepository;
        this.testUserRepository = testUserRepository;
        this.testFormatRepository = testFormatRepository;
        this.questionRepository = questionRepository;
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
    public void checkTest(List<TestUser> testUsers, Test test, TestFormat testFormat) {
        int correct = 0;

        for (TestUser testUser : testUsers) {
            if (testUser.isCorrect()) correct++;
        }

        System.out.println(correct);

        test.setPassed(correct >= testFormat.getThreshold());
    }

    @Override
    public void addTestUser(TestUser testUser) {
        testUserRepository.save(testUser);
    }

    @Override
    public void checkTestUser(TestUser testUser) {
        String correctAns = testUser.getAnswer().getText().toLowerCase();
        String userAns = testUser.getStudentAnswer().toLowerCase();

        testUser.setCorrect(userAns.equals(correctAns));
    }

    @Override
    public TestFormat addTestFormat(TestFormat testFormat) {
        return testFormatRepository.save(testFormat);
    }

    @Override
    public List<Question> generateTest(int questionsNum, Speciality speciality) {

        List<Question> questionList = (List) questionRepository.findAllBySpeciality(speciality);
        List<Question> testList = new ArrayList<>();

        for (int i = 0; i < questionsNum; i++) {

            Question q = questionList.get((int) (Math.random() * questionList.size()));
            testList.add(q);
            questionList.remove(q);
        }

        return testList;

    }

}
