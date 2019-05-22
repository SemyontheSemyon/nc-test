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

    private QuestionRepository questionRepository;
    private AnswerRepository answerRepository;
    private SpecialityRepository specialityRepository;
    private QuestionTypeRepository questionTypeRepository;

    @Autowired
    public QuestionEditConv(QuestionRepository questionRepository, AnswerRepository answerRepository, SpecialityRepository specialityRepository, QuestionTypeRepository questionTypeRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.specialityRepository = specialityRepository;
        this.questionTypeRepository = questionTypeRepository;
    }

    public QuestionDTO convertToDTO(Question question) {
        QuestionDTO dto = new QuestionDTO();
        List<Answer> answerList = answerRepository.findByQuestion(question);
        List<String> answers = new ArrayList<>();
        List<Answer> correctAnswer = answerRepository.findByQuestionAndCorrect(question, true);
        List<String> correstAnswerText = new ArrayList<>();

        dto.setId(question.getId());
        dto.setText(question.getText());
        dto.setType(question.getQuestionType().getName());
        for (Answer a : answerList) {
            answers.add(a.getText());
        }
        dto.setAnswers(answers);
        for (Answer a : correctAnswer) {
            correstAnswerText.add(a.getText());
        }
        dto.setCorrectAnswer(correstAnswerText);

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
