package com.ncTestService.services.impl;

import com.ncTestService.models.Role;
import com.ncTestService.models.User;
import com.ncTestService.models.UserInfo;
import com.ncTestService.repositories.RoleRepository;
import com.ncTestService.repositories.UserInfoRepository;
import com.ncTestService.repositories.UserRepository;
import com.ncTestService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private EmailServiceImpl emailService;

    @Override
    public User getUser(String username) {
        return userRepository.findByEmail(username);
    }

    @Override
    public User getPrincipialUser() {
        return userRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<UserInfo> getUserInfoByUserId(Long userId) {
        User user = userRepository.findById(userId).get();
        return userInfoRepository.findByUser(user);
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        if (userInfo.getEnrollment() != null) {
            emailService.scheduleEmail(userInfo);
        }
        userInfoRepository.save(userInfo);
    }


    @Override
    public Role getRole(String name) {
        return roleRepository.findByName(name);
    }
}
