package com.ncTestService.converters.Impl;

import com.ncTestService.DTO.QuestionDTO;
import com.ncTestService.models.Answer;
import com.ncTestService.models.Question;
import com.ncTestService.repositories.AnswerRepository;
import com.ncTestService.repositories.QuestionRepository;
import com.ncTestService.repositories.QuestionTypeRepository;
import com.ncTestService.repositories.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionEditConv {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    SpecialityRepository specialityRepository;

    @Autowired
    QuestionTypeRepository questionTypeRepository;

    public QuestionDTO convertToDTO(Question question) {
        QuestionDTO dto = new QuestionDTO();
        List<Answer> answerList = answerRepository.findByQuestion(question);
        List<String> answers = new ArrayList<>();
        Answer correctAnswer = answerRepository.findByQuestionAndAndCorrect(question, true);

        dto.setId(question.getId());
        dto.setText(question.getText());
        dto.setType(question.getQuestionType().getName());
        for (Answer a : answerList) {
            answers.add(a.getText());
        }
        dto.setAnswers(answers);
        dto.setCorrectAnswer(correctAnswer.getText());

        return dto;
    }

    public Question convertFromDTO(QuestionDTO dto) {
        Question question;

        if (dto.getId() == null) {
            question = new Question();
            question.setSpeciality(specialityRepository.findByName(dto.getSpeciality()));
            question.setQuestionType(questionTypeRepository.findByName(dto.getType()));
        } else {
            question = questionRepository.findById(dto.getId()).get();
        }

        question.setText(dto.getText());

        return question;

    }

}
