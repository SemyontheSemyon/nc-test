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
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserInfoController {

    @Autowired
    UserService userService;

    @Autowired
    UserInfoConv userInfoConv;

    @GetMapping("/api/profile")
    public ResponseEntity<?> getProfile() {

        User user = userService.getPrincipialUser();

        Optional<UserInfo> userInfo = userService.getUserInfoByUserId(user.getId());
        if(userInfo.isPresent())

            return new ResponseEntity(userInfoConv.userInfoToDto(userInfo.get()), HttpStatus.OK);
        return new ResponseEntity(new UserInfoDTO(), HttpStatus.OK);
    }

    @PostMapping("/api/profile")
    public ResponseEntity<?> updateProfile(@Valid @RequestBody UserInfoDTO userInfoDto) {
        userService.updateUserInfo(userInfoConv.userInfoFromDto(userInfoDto));
        return new ResponseEntity<>("User info updated successfully!", HttpStatus.OK);
    }

}
