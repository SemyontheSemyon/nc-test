package com.ncTestService.controllers;

import com.ncTestService.DTO.QuestionDTO;
import com.ncTestService.converters.Impl.QuestionEditConv;
import com.ncTestService.models.Answer;
import com.ncTestService.models.Question;
import com.ncTestService.models.Speciality;
import com.ncTestService.services.AnswerService;
import com.ncTestService.services.QuestionService;
import com.ncTestService.services.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class QuestionController {

    @Autowired
    QuestionEditConv conv;

    @Autowired
    QuestionService questionService;

    @Autowired
    AnswerService answerService;

    @Autowired
    SpecialityService specialityService;

    @GetMapping("/api/question/{specialityName}")
    public ResponseEntity getQuestions(@PathVariable String specialityName) {
        Speciality speciality = specialityService.getSpeciality(specialityName);
        List<Question> questions;
        if (speciality != null) {
            questions = questionService.getQuestions(speciality);
        } else questions = new ArrayList<>();

        List<QuestionDTO> dtoList = new ArrayList<>();

        for (Question question : questions) {
            dtoList.add(conv.convertToDTO(question));
        }

        return new ResponseEntity(dtoList, HttpStatus.OK);
    }

    @PostMapping("/api/question")
    public ResponseEntity postQuestion(@RequestBody QuestionDTO dto) {
        Question question = conv.convertFromDTO(dto);
        question = questionService.saveQuestion(question);
        List<Answer> answerList;

        if (dto.getId() != null) {
            answerList = answerService.getAnswer(question);
            answerService.deleteAll(answerList);
        }

        for (String answerText : dto.getAnswers()) {
            Answer answer = new Answer();
            answer.setQuestion(question);
            answer.setText(answerText);
            if (answerText.equals(dto.getCorrectAnswer())) {
                answer.setCorrect(true);
            }
            answerService.saveAnswer(answer);
        }

        return new ResponseEntity(HttpStatus.OK);


    }

    @DeleteMapping("/api/question/{questionId}")
    public ResponseEntity deleteQuestion(@PathVariable Long questionId) {

        Question question = questionService.getQuestion(questionId);
        if (question != null) questionService.deleteQuestion(question);

        return new ResponseEntity(HttpStatus.OK);
    }

}
