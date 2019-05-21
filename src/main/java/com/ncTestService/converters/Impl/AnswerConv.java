package com.ncTestService.converters.Impl;

import com.ncTestService.DTO.AnswerDTO;
import com.ncTestService.models.Question;
import com.ncTestService.models.TestUser;
import com.ncTestService.services.AnswerService;
import com.ncTestService.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerConv {

    QuestionService questionService;
    AnswerService answerService;

    @Autowired
    public AnswerConv(QuestionService questionService, AnswerService answerService) {
        this.questionService = questionService;
        this.answerService = answerService;
    }

    public TestUser convertFromDTO(AnswerDTO dto) {

        TestUser testUser = new TestUser();

        Question question = questionService.getQuestion(dto.getId());

        testUser.setQuestion(question);
        testUser.setAnswer(answerService.getCorrectAnswer(question));
        testUser.setStudentAnswer(dto.getStudentAnswer());

        return testUser;
    }

}
