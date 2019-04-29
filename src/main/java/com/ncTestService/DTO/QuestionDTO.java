package com.ncTestService.DTO;

import lombok.Data;

import java.util.List;

@Data
public class QuestionDTO {

    Long id;

    String type;

    String speciality;

    String text;

    List<String> answers;
    
    String correctAnswer;

}
