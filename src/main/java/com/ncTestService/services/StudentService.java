package com.ncTestService.services;

import com.ncTestService.DTO.UserTestDTO;

import java.util.List;

public interface StudentService {
    List<UserTestDTO> getAllUserTests();

    UserTestDTO getUserTest(String email);
}
