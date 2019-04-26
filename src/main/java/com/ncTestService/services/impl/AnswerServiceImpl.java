package com.ncTestService.services.impl;

import com.ncTestService.models.Answer;
import com.ncTestService.models.Question;
import com.ncTestService.repositories.AnswerRepository;
import com.ncTestService.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    private AnswerRepository answerRepository;

    @Autowired
    public AnswerServiceImpl(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public Answer getCorrectAnswer(Question question) {
        return answerRepository.findByQuestionAndAndCorrect(question, true);
    }

    @Override
    public List<Answer> getAnswer(Question question) {
        return answerRepository.findByQuestion(question);
    }
}
