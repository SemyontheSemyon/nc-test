package com.ncTestService.services;

import com.ncTestService.models.Question;

public interface QuestionService {

    Question getQuestion(Long id);

    Question saveQuestion(Question question);

    void deleteQuestion(Question question);

}
