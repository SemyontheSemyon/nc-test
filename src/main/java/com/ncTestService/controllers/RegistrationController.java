package com.ncTestService.controllers;


import com.ncTestService.models.User;
import com.ncTestService.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    UserService userService;

    @PostMapping()
    public ResponseEntity registry(@RequestBody User user) {

        userService.addUser(user);

        return ResponseEntity.ok(HttpStatus.OK);

    }

}
