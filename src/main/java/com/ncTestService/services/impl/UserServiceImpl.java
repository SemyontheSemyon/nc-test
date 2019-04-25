package com.ncTestService.services.impl;

import com.ncTestService.models.*;
import com.ncTestService.repositories.*;
import com.ncTestService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    UserInfoRepository userInfoRepository;
    CityRepository cityRepository;
    CountryRepository countryRepository;
    EnrollmentRepository enrollmentRepository;
    SpecialityRepository specialityRepository;
    TechRepository techRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserInfoRepository userInfoRepository, CityRepository cityRepository, CountryRepository countryRepository, EnrollmentRepository enrollmentRepository, SpecialityRepository specialityRepository, TechRepository techRepository) {
        this.userRepository = userRepository;
        this.userInfoRepository = userInfoRepository;
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
        this.enrollmentRepository = enrollmentRepository;
        this.specialityRepository = specialityRepository;
        this.techRepository = techRepository;
    }

    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByLogin(username);
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Iterable<UserInfo> getAllUserInfo() {
        return userInfoRepository.findAll();
    }

    @Override
    public UserInfo getUserInfo(Long id) {
        return userInfoRepository.findById(id).get();
    }

    @Override
    public UserInfo getUserInfo(User user) {
        return userInfoRepository.findByUser(user).get();
    }

    @Override
    public UserInfo getUserInfoByUserId(Long userId) {
        User user = userRepository.findById(userId).get();
        return userInfoRepository.findByUser(user).get();
    }

    @Override
    public void addUserInfo(UserInfo userInfo) {
        userInfoRepository.save(userInfo);
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        userInfoRepository.save(userInfo);
    }

    @Override
    public void deleteUserInfo(Long id) {
        userInfoRepository.deleteById(id);
    }

    @Override
    public List<UserInfo> findByUserName(String firstName, String lastName) {
        return userInfoRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public List<UserInfo> findBySpeciality(String speciality) {
        return userInfoRepository.findBySpeciality(specialityRepository.findByName(speciality));
    }
}
