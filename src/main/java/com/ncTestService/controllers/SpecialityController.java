package com.ncTestService.controllers;


import com.ncTestService.models.Question;
import com.ncTestService.models.Speciality;
import com.ncTestService.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/speciality")
public class SpecialityController {

    @GetMapping("/{specialityName}")
    public Speciality getSpeciality(@PathVariable String specialityName) {

        //implement

        return new Speciality();

    }

    @PostMapping("/{specialityName}/{enrollmentId}")
    public ResponseEntity addEnrollment(@RequestBody User user) {

        //implement

        return ResponseEntity.ok(HttpStatus.OK);

    }

    @GetMapping("/{specialityName}/questions")
    public List<Question> getQuestions(@PathVariable String specialityName) {

        //implement

        return new ArrayList<>();

    }

}
