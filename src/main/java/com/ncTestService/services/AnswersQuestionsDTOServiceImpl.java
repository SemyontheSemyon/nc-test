package com.ncTestService.services;

import com.ncTestService.DTO.AnswersQuestionsDTO;
import com.ncTestService.models.Answer;
import com.ncTestService.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AnswersQuestionsDTOServiceImpl implements AnswersQuestionsDTOService {

    @Autowired
    AnswerService answerService;

    @Override
    public AnswersQuestionsDTO createDTO(List<Question> questionList) {

        AnswersQuestionsDTO dto = new AnswersQuestionsDTO();

        List<List<Answer>> answerList = answerService.getAnswers(questionList);

        Map<Question, List<Answer>> AQMap = new HashMap<>();

        for(int i = 0; i < questionList.size(); i++) {

            AQMap.put(questionList.get(i), answerList.get(i));

        }

        dto.setQuestionAnswersMap(AQMap);

        return dto;

    }


}
