package com.ncTestService.converters.Impl;

import com.ncTestService.DTO.UserTestDTO;
import com.ncTestService.models.Test;
import com.ncTestService.repositories.TestUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserTestConv {

    @Autowired
    TestUserRepository testUserRepository;

    public UserTestDTO getUserTestDTO(Test test) {
        UserTestDTO userTestDTO = new UserTestDTO();

        userTestDTO.setEmail(test.getUser().getEmail());
        userTestDTO.setPassed(test.isPassed());
        userTestDTO.setTakenAt(test.getTakenAt());
        testUserRepository.findByTest(test).forEach(testUser -> {
            userTestDTO.getUserAnswers().add(testUser);
        });

        return userTestDTO;
    }
}
