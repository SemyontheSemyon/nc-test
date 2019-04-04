package com.ncTestService.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {


    @GetMapping()
    public List<Map<String, String>> login(@RequestParam(name = "username") String username,
                                           @RequestParam(name = "password") String password) {
        List<Map<String, String>> list = new ArrayList<>();

        //implement

        return list;
    }



}
