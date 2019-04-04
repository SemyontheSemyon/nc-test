package com.ncTestService.controllers;


import com.ncTestService.models.Enrollment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {

    @PostMapping
    public ResponseEntity createEnrollment(@RequestBody Enrollment enrollment) {

        //implement

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{enrollmentId}")
    public Enrollment getEnrollmenr(@PathVariable Long enrollmentId) {

        //implement

        return new Enrollment();

    }


}
