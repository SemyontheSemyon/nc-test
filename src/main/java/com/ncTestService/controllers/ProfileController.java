package com.ncTestService.controllers;


import com.ncTestService.models.EnrollmentCityTestFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @GetMapping
    public List<EnrollmentCityTestFormat> getEnrollments() {

        //implement

        return new ArrayList<>();

    }


}
