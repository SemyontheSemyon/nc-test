package com.ncTestService.services.impl;

import com.ncTestService.models.Question;
import com.ncTestService.models.Speciality;
import com.ncTestService.repositories.QuestionRepository;
import com.ncTestService.repositories.SpecialityRepository;
import com.ncTestService.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    SpecialityRepository specialityRepository;

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
