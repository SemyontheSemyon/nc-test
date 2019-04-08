package com.ncTestService.repositories;

import com.ncTestService.models.Answer;
import com.ncTestService.models.Question;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnswerRepository extends CrudRepository<Answer, Long> {
    Answer findByText(String text);
    List<Answer> findByQuestion(Question question);
    Answer findByQuestionAndAndCorrect(Question question, boolean correct);
}
