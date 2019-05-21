package com.ncTestService.converters.Impl;

import com.ncTestService.DTO.UserInfoDTO;
import com.ncTestService.models.User;
import com.ncTestService.models.UserInfo;
import com.ncTestService.repositories.EnrollmentCityTestFormatRepository;
import com.ncTestService.services.CityService;
import com.ncTestService.services.SpecialityService;
import com.ncTestService.services.UserService;
import com.ncTestService.services.impl.EnrollmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoConv {

    EnrollmentCityTestFormatRepository enrollmentRepository;
    UserService userService;

    @Autowired
    public UserInfoConv(EnrollmentCityTestFormatRepository enrollmentRepository, UserService userService) {
        this.enrollmentRepository = enrollmentRepository;
        this.userService = userService;
    }

    public UserInfo userInfoFromDto(UserInfoDTO userInfoDto) {
        User user = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
        UserInfo userInfo;
        Optional<UserInfo> userInfoOpt = userService.getUserInfoByUserId(user.getId());
        if (userInfoOpt.isPresent()) {
            userInfo = userInfoOpt.get();
        } else {
            userInfo = new UserInfo();
        }
        userInfo.setStudentStatus(userInfoDto.getStudentStatus());
        userInfo.setFirstName(userInfoDto.getFirstName());
        userInfo.setLastName(userInfoDto.getLastName());
        userInfo.setCity(userInfoDto.getCity());
        userInfo.setUniversity(userInfoDto.getUniversity());
        userInfo.setGrade(userInfoDto.getGrade());
        userInfo.setDepartment(userInfoDto.getDepartment());
        userInfo.setSpeciality(userInfoDto.getSpeciality());
        userInfo.setPhone(userInfoDto.getPhone());
        userInfo.setUser(user);
        if (userInfoDto.getEnrollmentId() != null)
            userInfo.setEnrollment(enrollmentRepository.findById(userInfoDto.getEnrollmentId()).get());
        return userInfo;
    }

    public UserInfoDTO userInfoToDto(UserInfo userInfo) {
        UserInfoDTO userInfoDto = new UserInfoDTO();
        userInfoDto.setStudentStatus(userInfo.getStudentStatus());
        userInfoDto.setFirstName(userInfo.getFirstName());
        userInfoDto.setLastName(userInfo.getLastName());
        userInfoDto.setCity(userInfo.getCity());
        userInfoDto.setUniversity(userInfo.getUniversity());
        userInfoDto.setDepartment(userInfo.getDepartment());
        userInfoDto.setSpeciality(userInfo.getSpeciality());
        userInfoDto.setGrade(userInfo.getGrade());
        userInfoDto.setPhone(userInfo.getPhone());
        if (userInfo.getEnrollment() != null) {
            userInfoDto.setTestStart(userInfo.getEnrollment().getEnrollment().getTestStart());
            userInfoDto.setTestEnd(userInfo.getEnrollment().getEnrollment().getTestEnd());
            userInfoDto.setEnrollmentId(userInfo.getEnrollment().getId());
        }
        return userInfoDto;
    }
}
