package com.ncTestService.services.impl;

import com.ncTestService.models.Question;
import com.ncTestService.repositories.QuestionRepository;
import com.ncTestService.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question getQuestion(Long id) {

        return questionRepository.findById(id).get();

    }
}
