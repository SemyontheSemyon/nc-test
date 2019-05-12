package com.ncTestService.dbInit.entitiesInit.Impl;

import com.ncTestService.models.Question;
import com.ncTestService.models.QuestionType;
import com.ncTestService.models.Speciality;
import com.ncTestService.repositories.QuestionRepository;
import com.ncTestService.repositories.QuestionTypeRepository;
import com.ncTestService.repositories.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionInitImpl {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    SpecialityRepository specialityRepository;

    @Autowired
    QuestionTypeRepository questionTypeRepository;

    public void initQuestions() {

        List<Speciality> specialities = (List) specialityRepository.findAll();
        List<QuestionType> questionTypes = (List) questionTypeRepository.findAll();
        for (int i = 1; i < 21; i++) {
            for (Speciality speciality : specialities) {
                for (QuestionType questionType : questionTypes) {

                    Question question = new Question();
                    question.setText(questionType.getName() + speciality.getName() + i);
                    question.setQuestionType(questionType);
                    question.setSpeciality(speciality);
                    questionRepository.save(question);

                }
            }
        }


    }

}
