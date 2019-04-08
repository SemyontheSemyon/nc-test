package com.ncTestService.services;

import com.ncTestService.DTO.AnswersQuestionsDTO;
import com.ncTestService.models.Answer;
import com.ncTestService.models.Question;

import java.util.List;

public interface AnswersQuestionsDTOService {

    AnswersQuestionsDTO createDTO(List<Question> questionList);

}
