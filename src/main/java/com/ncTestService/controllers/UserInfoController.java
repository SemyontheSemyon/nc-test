package com.ncTestService.controllers;

import com.ncTestService.DTO.UserInfoDTO;
import com.ncTestService.converters.Impl.UserInfoConv;
import com.ncTestService.models.User;
import com.ncTestService.models.UserInfo;
import com.ncTestService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserInfoController {

    @Autowired
    UserService userService;

    @Autowired
    UserInfoConv userInfoConv;

    @GetMapping("/api/profile")
    public ResponseEntity<?> getProfile() {

        User user = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());

        UserInfo userInfo;
        if (userService.getUserInfoByUserId(user.getId()) != null) {
            userInfo = userService.getUserInfoByUserId(user.getId());
        } else {
            userInfo = new UserInfo();
        }
            return new ResponseEntity(userInfoConv.userInfoToDto(userInfo), HttpStatus.OK);
        return new ResponseEntity(new UserInfoDTO(), HttpStatus.OK);
    }

    @PostMapping("/api/profile")
    public ResponseEntity<?> updateProfile(@Valid @RequestBody UserInfoDTO userInfoDto) {
        userService.updateUserInfo(userInfoConv.userInfoFromDto(userInfoDto));
        return new ResponseEntity<>("User info updated successfully!", HttpStatus.OK);
    }

}
