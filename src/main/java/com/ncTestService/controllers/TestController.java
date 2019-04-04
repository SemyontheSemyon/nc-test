package com.ncTestService.controllers;

import com.ncTestService.models.AnswerType;
import com.ncTestService.models.Question;
import com.ncTestService.repositories.AnswerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public List<Question> getQuestions(@RequestParam(name = "specialityName") String specialityName) {

        //implement

        return new ArrayList<>();

    }

    @PostMapping
    public ResponseEntity createTestUsers(@RequestBody List<Question> questions) {

        //implement

        return ResponseEntity.ok(HttpStatus.OK);

    }


    //узнать про GET /test/finished

}
