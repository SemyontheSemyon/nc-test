package com.ncTestService.controllers;


import com.ncTestService.models.TestFormat;
import com.ncTestService.services.interfaces.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test_format")
public class TestFormatController {

    @Autowired
    TestService testService;

    @GetMapping()
    public List<TestFormat> getTestFormats() {

        return (List)testService.getAllTestFormats();

    }

}
