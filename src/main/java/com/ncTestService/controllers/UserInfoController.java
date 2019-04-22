package com.ncTestService.controllers;

import com.ncTestService.models.UserInfo;
import com.ncTestService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("userinfo")
public class UserInfoController {

    @Autowired
    UserService userService;

    @GetMapping("/{userId}")
    UserInfo getUserInfo(@PathVariable Long userId) {
        return userService.getUserInfoByUserId(userId);
    }

    @PutMapping("/update")
    ResponseEntity updateUserInfo(@RequestBody UserInfo userInfo) {
        userService.updateUserInfo(userInfo);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
