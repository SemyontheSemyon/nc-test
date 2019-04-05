package com.ncTestService.controllers;


import com.ncTestService.models.Question;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @GetMapping("/{questionId}")
    public Question getQuestion(@PathVariable Long questionId) {

        //implement

        return new Question();

    }

    @PostMapping("/new")
    public ResponseEntity createQuestion(@RequestBody Question question) {

        //implement

        return ResponseEntity.ok(HttpStatus.OK);
    }



}
