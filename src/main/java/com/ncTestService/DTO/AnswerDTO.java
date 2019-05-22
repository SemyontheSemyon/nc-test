package com.ncTestService.DTO;

import lombok.Data;

import java.util.List;

@Data
public class AnswerDTO {

    Long id;

    List<String> studentAnswer;

}
