package com.ncTestService.controllers;


import com.ncTestService.models.UserInfo;
import com.ncTestService.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    UserService userService;

    @GetMapping("/{studentId}")
    public UserInfo getStudent(@PathVariable Long studentId) {

        return userService.getUserInfoByUserId(studentId);

    }

}
