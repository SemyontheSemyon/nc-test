package com.ncTestService.converters.Impl;

import com.ncTestService.DTO.QuestionDTO;
import com.ncTestService.models.Answer;
import com.ncTestService.models.Question;
import com.ncTestService.repositories.AnswerRepository;
import com.ncTestService.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionConv {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;

    public QuestionDTO convertToDTO(Question question) {

        QuestionDTO dto = new QuestionDTO();

        List<Answer> answers = answerRepository.findByQuestion(question);

        dto.setId(question.getId());
        dto.setType(question.getQuestionType().getName());
        dto.setText(question.getText());
        dto.setAnswers(new ArrayList<>());

        if (!question.getQuestionType().getName().equals("free"))
            for (Answer answer : answers) {
                dto.getAnswers().add(answer.getText());
            }

        return dto;

    }

}
