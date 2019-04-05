package com.ncTestService.controllers;


import com.ncTestService.models.UserInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/{studentId}")
    public UserInfo getStudent(@PathVariable Long studentId) {

        //implement

        return new UserInfo();

    }

}
