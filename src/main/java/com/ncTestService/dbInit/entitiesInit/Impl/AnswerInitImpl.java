package com.ncTestService.dbInit.entitiesInit.Impl;

import com.ncTestService.models.Answer;
import com.ncTestService.models.Question;
import com.ncTestService.repositories.AnswerRepository;
import com.ncTestService.repositories.QuestionRepository;
import com.ncTestService.repositories.QuestionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnswerInitImpl {

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    QuestionTypeRepository questionTypeRepository;

    public void initAnswers() {

        List<Question> questions = (List) questionRepository.findAll();

        for (Question question : questions) {

            if (question.getQuestionType().equals(questionTypeRepository.findByName("free"))) {
                Answer answer = new Answer("A", true);
                answer.setQuestion(question);
                answerRepository.save(answer);
            }

            if (question.getQuestionType().equals(questionTypeRepository.findByName("radio"))) {
                Answer answer = new Answer("A", true);
                Answer answer1 = new Answer("B", false);
                Answer answer2 = new Answer("C", false);
                Answer answer3 = new Answer("D", false);

                answer.setQuestion(question);
                answer1.setQuestion(question);
                answer2.setQuestion(question);
                answer3.setQuestion(question);

                answerRepository.save(answer);
                answerRepository.save(answer1);
                answerRepository.save(answer2);
                answerRepository.save(answer3);
            }
        }


    }

}
