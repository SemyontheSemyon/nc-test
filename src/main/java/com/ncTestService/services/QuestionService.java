package com.ncTestService.services;

import com.ncTestService.models.Question;
import com.ncTestService.models.Speciality;

import java.util.List;

public interface QuestionService {

    Question getQuestion(Long id);

    Question saveQuestion(Question question);

    List<Question> getQuestions(Speciality speciality);

    void deleteQuestion(Question question);

}
