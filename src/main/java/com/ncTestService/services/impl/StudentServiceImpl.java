package com.ncTestService.services.impl;

import com.ncTestService.DTO.UserTestDTO;
import com.ncTestService.converters.Impl.UserTestConv;
import com.ncTestService.models.Test;
import com.ncTestService.repositories.TestRepository;
import com.ncTestService.repositories.TestUserRepository;
import com.ncTestService.repositories.UserRepository;
import com.ncTestService.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    TestRepository testRepository;

    @Autowired
    TestUserRepository testUserRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserTestConv userTestConv;

    @Override
    public List<UserTestDTO> getAllUserTests() {
        List<UserTestDTO> userTestDTOS = new ArrayList<>();
        testRepository.findAll().forEach(test -> {
            userTestDTOS.add(userTestConv.getUserTestDTO(test));
        });
        return userTestDTOS;
    }

    @Override
    public UserTestDTO getUserTest(String email) {
        Test test = testRepository.findByUser(userRepository.findByEmail(email));
        return userTestConv.getUserTestDTO(test);
    }
}
