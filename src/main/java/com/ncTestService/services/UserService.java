package com.ncTestService.services;

import com.ncTestService.models.*;

import java.util.Date;
import java.util.List;

public interface UserService {

    Iterable<User> getAllUsers();
    User getUser(Long id);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);

    Iterable<UserInfo> getAllUserInfo();
    UserInfo getUserInfo(Long id);
    void addUserInfo(UserInfo user);
    void updateUserInfo(UserInfo user);
    void deleteUserInfo(Long id);

    Iterable<UserTech> getAllUserTechs();
    UserTech getUserTech(Long id);
    void addUserTech(UserTech user);
    void updateUserTech(UserTech user);
    void deleteUserTech(Long id);

    List<UserInfo> findByUserName(String firstName, String lastName);
    List<UserInfo> findByUserStatus(String userStatus);
    List<UserInfo> findByCity(String city);
    List<UserInfo> findBySpeciality(String speciality);
    List<UserInfo> findByEnrollment(Date appStart);

    List<City> findByCountry(String name);

}
