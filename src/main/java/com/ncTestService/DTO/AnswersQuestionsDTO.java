package com.ncTestService.DTO;

import com.ncTestService.models.Answer;
import com.ncTestService.models.Question;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
public class AnswersQuestionsDTO {

    Map<Question, List<Answer>> questionAnswersMap;

}
