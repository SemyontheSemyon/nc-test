package com.ncTestService.controllers;

import com.ncTestService.DTO.UserTestDTO;
import com.ncTestService.services.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController()
public class StudentController {

    StudentServiceImpl studentService;

    @Autowired
    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/api/usertests")
    List<UserTestDTO> getUserTests() {
        return studentService.getAllUserTests();
    }

}
