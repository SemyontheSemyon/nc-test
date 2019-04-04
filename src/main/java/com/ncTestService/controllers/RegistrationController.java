package com.ncTestService.controllers;


import com.ncTestService.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/registration")
public class RegistrationController {

    @PostMapping()
    public ResponseEntity registry(@RequestBody User user) {

        //implement

        return  ResponseEntity.ok(HttpStatus.OK);

    }

}
