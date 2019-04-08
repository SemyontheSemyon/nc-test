package com.ncTestService.DTO;

import com.ncTestService.models.Question;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class TestUserDTO {

    Long userId;

    Map<Question, String> questionAnswerMap;

}
