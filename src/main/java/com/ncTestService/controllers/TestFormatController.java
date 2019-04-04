package com.ncTestService.controllers;


import com.ncTestService.models.TestFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test_format")
public class TestFormatController {

    @GetMapping()
    public List<TestFormat> getTestFormats() {

        //implement

        return new ArrayList<>();

    }

}
