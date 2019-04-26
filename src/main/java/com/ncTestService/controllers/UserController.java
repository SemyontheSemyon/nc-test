package com.ncTestService.controllers;

import com.ncTestService.DTO.JwtDTO;
import com.ncTestService.models.Role;
import com.ncTestService.models.User;
import com.ncTestService.security.TokenProvider;
import com.ncTestService.services.RoleService;
import com.ncTestService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    TokenProvider tokenProvider;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("api/auth/registration")
    public ResponseEntity createUser(@RequestBody User userReq) {
        User user = new User();

        user.setEmail(userReq.getEmail());
        user.setPassword(encoder.encode(userReq.getPassword()));
        user.setRoles(new HashSet<Role>());
        user.getRoles().add(roleService.getRole("ROLE_USER"));

        userService.addUser(user);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("api/auth/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateJwtToken(authentication);
        System.out.println(jwt);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
    }

}
