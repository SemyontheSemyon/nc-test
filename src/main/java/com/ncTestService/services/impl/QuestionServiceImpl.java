package com.ncTestService.services.impl;

import com.ncTestService.models.Question;
import com.ncTestService.repositories.QuestionRepository;
import com.ncTestService.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> getQuestions(String specialityName) {

        Speciality speciality = specialityRepository.findByName(specialityName);

        if(speciality == null) return new ArrayList<>();
        return (List)questionRepository.findBySpeciality(speciality);
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
    public void deleteQuestion(Question question) {
        questionRepository.delete(question);
    }
}
