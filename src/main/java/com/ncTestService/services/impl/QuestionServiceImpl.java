package com.ncTestService.services.impl;

import com.ncTestService.models.Question;
import com.ncTestService.models.Speciality;
import com.ncTestService.repositories.QuestionRepository;
import com.ncTestService.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;


    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    @Override
    public Question getQuestion(Long id) {

        return questionRepository.findById(id).get();

    }

    @Override
    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getQuestions(Speciality speciality) {
        return (List) questionRepository.findAllBySpeciality(speciality);
    }

    @Override
    public void deleteQuestion(Question question) {
        questionRepository.delete(question);
    }
}
