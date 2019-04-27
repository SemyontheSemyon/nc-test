package com.ncTestService.DTO;

import lombok.Data;

import java.util.List;

@Data
public class QuestionDTO {

    Long questionId;

    String type;

    String text;

    List<String> answers;
    
    String speciality;
    
    String correctAnswer;

}
