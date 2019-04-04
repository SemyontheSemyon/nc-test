package com.ncTestService.controllers;


import com.ncTestService.models.Speciality;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController("/home")
public class HomeController {

    @GetMapping()
    public List<Speciality> home() {

        //implement

        return new ArrayList<>();

    }

}
