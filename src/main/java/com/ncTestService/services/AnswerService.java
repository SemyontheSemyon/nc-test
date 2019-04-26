package com.ncTestService.services;

import com.ncTestService.models.Answer;
import com.ncTestService.models.Question;

import java.util.List;

public interface AnswerService {

    Answer getCorrectAnswer(Question question);

    List<Answer> getAnswer(Question question);

}
