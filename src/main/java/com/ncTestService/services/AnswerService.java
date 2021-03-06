package com.ncTestService.services;

import com.ncTestService.models.Answer;
import com.ncTestService.models.Question;

import java.util.List;

public interface AnswerService {

    Answer saveAnswer(Answer answer);

    Answer getAnswer(Long id);

    List<Answer> getCorrectAnswer(Question question);

    List<Answer> getAnswer(Question question);

    List<List<Answer>> getAnswers(List<Question> questionList);

    void deleteAll(Iterable<Answer> answers);

}
