package com.ncTestService.services;

import com.ncTestService.models.*;
import com.ncTestService.repositories.*;
import com.ncTestService.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    UserTechRepository userTechRepository;
    UserInfoRepository userInfoRepository;
    CityRepository cityRepository;
    CountryRepository countryRepository;
    EnrollmentRepository enrollmentRepository;
    SpecialityRepository specialityRepository;
    StudentStatusRepository studentStatusRepository;
    TechRepository techRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserTechRepository userTechRepository, UserInfoRepository userInfoRepository, CityRepository cityRepository, CountryRepository countryRepository, EnrollmentRepository enrollmentRepository, SpecialityRepository specialityRepository, StudentStatusRepository studentStatusRepository, TechRepository techRepository) {
        this.userRepository = userRepository;
        this.userTechRepository = userTechRepository;
        this.userInfoRepository = userInfoRepository;
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
        this.enrollmentRepository = enrollmentRepository;
        this.specialityRepository = specialityRepository;
        this.studentStatusRepository = studentStatusRepository;
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
    public Iterable<UserTech> getAllUserTechs() {
        return userTechRepository.findAll();
    }

    @Override
    public UserTech getUserTech(Long id) {
        return userTechRepository.findById(id).get();
    }

    @Override
    public void addUserTech(UserTech userTech) {
        userTechRepository.save(userTech);
    }

    @Override
    public void updateUserTech(UserTech userTech) {
        userTechRepository.save(userTech);
    }

    @Override
    public void deleteUserTech(Long id) {
        userTechRepository.deleteById(id);
    }

    @Override
    public List<UserInfo> findByUserName(String firstName, String lastName) {
        return userInfoRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public List<UserInfo> findByUserStatus(String userStatus) {
        return userInfoRepository.findByStudentStatus(studentStatusRepository.findByName(userStatus));
    }

    @Override
    public List<UserInfo> findBySpeciality(String speciality) {
        return userInfoRepository.findBySpeciality(specialityRepository.findByName(speciality));
    }
}
