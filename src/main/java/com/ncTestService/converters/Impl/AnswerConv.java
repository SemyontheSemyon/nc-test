package com.ncTestService.converters.Impl;

import com.ncTestService.DTO.AnswerDTO;
import com.ncTestService.models.Answer;
import com.ncTestService.models.Question;
import com.ncTestService.models.TestUser;
import com.ncTestService.services.AnswerService;
import com.ncTestService.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerConv {

    private QuestionService questionService;
    private AnswerService answerService;

    @Autowired
    public AnswerConv(QuestionService questionService, AnswerService answerService) {
        this.questionService = questionService;
        this.answerService = answerService;
    }

    public TestUser convertFromDTO(AnswerDTO dto) {

        TestUser testUser = new TestUser();
        Question question = questionService.getQuestion(dto.getId());
        StringBuilder studentAns = new StringBuilder();
        StringBuilder correctAns = new StringBuilder();

        testUser.setQuestion(question);

        for (String s : dto.getStudentAnswer()) {
            studentAns.append(s).append(". ");
        }

        testUser.setStudentAnswer(studentAns.toString());

        for (Answer a : answerService.getCorrectAnswer(question)) {
            correctAns.append(a.getText()).append(". ");
        }

        testUser.setAnswer(correctAns.toString());

        return testUser;
    }

}
