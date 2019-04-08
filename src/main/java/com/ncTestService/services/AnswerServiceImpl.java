package com.ncTestService.services;

import com.ncTestService.models.Answer;
import com.ncTestService.models.Question;
import com.ncTestService.repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    AnswerRepository answerRepository;

    @Override
    public Answer getAnswer(Long id) {
        return answerRepository.findById(id).get();
    }

    @Override
    public Answer getCorrectAnswer(Question question) {
        return answerRepository.findByQuestionAndAndCorrect(question, true);
    }

    @Override
    public List<Answer> getAnswer(Question question) {
        return answerRepository.findByQuestion(question);
    }

    @Override
    public List<List<Answer>> getAnswers(List<Question> questionList) {
        List<List<Answer>> answersList = new ArrayList<>();

        for(Question q : questionList) {

            List<Answer> list = getAnswer(q);

            answersList.add(list);

        }

        return answersList;

    }
}
