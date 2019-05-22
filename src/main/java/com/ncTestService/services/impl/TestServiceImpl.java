package com.ncTestService.services.impl;

import com.ncTestService.DTO.AnswerDTO;
import com.ncTestService.models.*;
import com.ncTestService.repositories.*;
import com.ncTestService.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestServiceImpl implements TestService {

    private TestRepository testRepository;
    private TestUserRepository testUserRepository;
    private TestFormatRepository testFormatRepository;
    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;

    @Autowired
    public TestServiceImpl(TestRepository testRepository, TestUserRepository testUserRepository, TestFormatRepository testFormatRepository, QuestionRepository questionRepository,
                           AnswerRepository answerRepository) {
        this.testRepository = testRepository;
        this.testUserRepository = testUserRepository;
        this.testFormatRepository = testFormatRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
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
    public boolean checkAnswers(AnswerDTO dto) {
        List<String> studentAns = dto.getStudentAnswer();
        Question question = questionRepository.findById(dto.getId()).get();
        List<Answer> answers = answerRepository.findByQuestionAndCorrect(question, true);
        List<String> answersText = new ArrayList<>();

        for (Answer a : answers) {
            answersText.add(a.getText().toLowerCase());
        }

        studentAns = studentAns.stream().map(s -> s.toLowerCase()).collect(Collectors.toList());

        Collections.sort(studentAns);
        Collections.sort(answersText);

        return answersText.equals(studentAns);
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
