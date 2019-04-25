package com.ncTestService.dbInit.entitiesInit.Impl;

import com.ncTestService.dbInit.entitiesInit.QuestionTypeInit;
import com.ncTestService.models.QuestionType;
import com.ncTestService.repositories.QuestionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuestionTypeInitImpl implements QuestionTypeInit {

    @Autowired
    QuestionTypeRepository questionTypeRepository;

    @Override
    public void initQuestionTypes() {
        questionTypeRepository.save(new QuestionType("radio"));
        questionTypeRepository.save(new QuestionType("free"));
    }
}
