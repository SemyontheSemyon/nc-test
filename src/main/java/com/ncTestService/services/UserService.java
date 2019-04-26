package com.ncTestService.services;

import com.ncTestService.models.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UserService {

    Iterable<User> getAllUsers();
    User getUser(Long id);
    User getUser(String username);
    User getPrincipialUser();
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);

    Iterable<UserInfo> getAllUserInfo();
    UserInfo getUserInfo(Long id);
    UserInfo getUserInfo(User user);
    Optional<UserInfo> getUserInfoByUserId(Long userId);
    void addUserInfo(UserInfo userInfo);
    void updateUserInfo(UserInfo userInfo);
    void deleteUserInfo(Long id);

    List<UserInfo> findByUserName(String firstName, String lastName);
    List<UserInfo> findBySpeciality(String speciality);



}
