package com.ncTestService.controllers;

import com.ncTestService.models.AnswerType;
import com.ncTestService.repositories.AnswerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class TestController {

    AnswerTypeRepository answerTypeRepository;

    @Autowired
    public TestController(AnswerTypeRepository answerTypeRepository) {
        this.answerTypeRepository = answerTypeRepository;
    }

    @GetMapping
    public Iterable<AnswerType> getAnswerTypes() {
        return answerTypeRepository.findAll();
    }

    @PostMapping(path = "/{type}")
    public AnswerType addAnswerType (@PathVariable("type") String type){
        AnswerType answerType = new AnswerType();
        answerType.setType(type);

        return answerTypeRepository.save(answerType);
    }

}
