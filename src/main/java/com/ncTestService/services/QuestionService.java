package com.ncTestService.services;

import com.ncTestService.models.Question;

import java.util.List;

public interface QuestionService {

    List<Question> getQuestions(String specialityName);

    Question getQuestion(Long id);

    Question saveQuestion(Question question);

    void deleteQuestion(Question question);

}
