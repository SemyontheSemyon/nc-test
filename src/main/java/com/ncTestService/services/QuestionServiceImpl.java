package com.ncTestService.services;

import com.ncTestService.models.Question;
import com.ncTestService.models.Speciality;
import com.ncTestService.repositories.QuestionRepository;
import com.ncTestService.repositories.SpecialityRepository;
import com.ncTestService.services.interfaces.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        return questionRepository.findBySpeciality(speciality);
    }

    @Override
    public Question getQuestion(Long id) {

        return questionRepository.findById(id).get();

    }
}
