package com.ncTestService.services;

import com.ncTestService.models.Role;
import com.ncTestService.models.User;
import com.ncTestService.models.UserInfo;

import java.util.Optional;

public interface UserService {

    User getUser(String username);

    User getPrincipialUser();

    void addUser(User user);

    Optional<UserInfo> getUserInfoByUserId(Long userId);

    void updateUserInfo(UserInfo userInfo);

    Role getRole(String name);

}
