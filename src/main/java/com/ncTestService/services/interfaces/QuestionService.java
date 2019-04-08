package com.ncTestService.services.interfaces;

import com.ncTestService.models.Question;

import java.util.List;

public interface QuestionService {

    List<Question> getQuestions(String specialityName);

    Question getQuestion(Long id);

}
