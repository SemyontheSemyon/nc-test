package com.ncTestService.DTO;

import com.ncTestService.models.TestUser;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserTestDTO {

    List<TestUser> userAnswers;
    private String email;
    private Date takenAt;
    private boolean passed;

}
