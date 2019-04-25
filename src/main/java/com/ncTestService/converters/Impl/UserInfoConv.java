package com.ncTestService.converters.Impl;

import com.ncTestService.DTO.UserInfoDTO;
import com.ncTestService.models.User;
import com.ncTestService.models.UserInfo;
import com.ncTestService.repositories.CityRepository;
import com.ncTestService.repositories.EnrollmentCityTestFormatRepository;
import com.ncTestService.repositories.EnrollmentRepository;
import com.ncTestService.services.CityService;
import com.ncTestService.services.SpecialityService;
import com.ncTestService.services.UserService;
import com.ncTestService.services.impl.EnrollmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

@Component
public class UserInfoConv {

    @Autowired
    EnrollmentServiceImpl enrollmentService;
    @Autowired
    EnrollmentCityTestFormatRepository enrollmentRepository;
    @Autowired
    UserService userService;
    @Autowired
    UserService userInfoService;
    @Autowired
    CityService cityService;
    @Autowired
    SpecialityService specialityService;

    public UserInfo userInfoFromDto(UserInfoDTO userInfoDto) {
        System.out.println("UserInfoDto in userInfoFromDto: " + userInfoDto);

        User user = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());

        UserInfo userInfo;
        if (userService.getUserInfoByUserId(user.getId()) != null) {
            userInfo = userService.getUserInfoByUserId(user.getId());
        } else {
            userInfo = new UserInfo();
        }

        userInfo.setStudentStatus(userInfoDto.getStudentStatus());
        userInfo.setFirstName(userInfoDto.getFirstName());
        userInfo.setLastName(userInfoDto.getLastName());
        userInfo.setCity(cityService.findByName(userInfoDto.getCity()));
        userInfo.setUniversity(userInfoDto.getUniversity());
        userInfo.setGrade(userInfoDto.getGrade());
        userInfo.setDepartment(userInfoDto.getDepartment());
        userInfo.setSpeciality(specialityService.getSpeciality(userInfoDto.getSpeciality()));
        userInfo.setPhone(userInfoDto.getPhone());

        userInfo.setUser(user);
        if (userInfoDto.getEnrollmentId() != null)
            userInfo.setEnrollment(enrollmentRepository.findById(userInfoDto.getEnrollmentId()).get());

        return userInfo;
    }

    public UserInfoDTO userInfoToDto(UserInfo userInfo) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        UserInfoDTO userInfoDto = new UserInfoDTO();

        userInfoDto.setStudentStatus(userInfo.getStudentStatus());
        userInfoDto.setFirstName(userInfo.getFirstName());
        userInfoDto.setLastName(userInfo.getLastName());
        userInfoDto.setCity(userInfo.getCity().getName());
        userInfoDto.setUniversity(userInfo.getUniversity());
        userInfoDto.setDepartment(userInfo.getDepartment());
        userInfoDto.setSpeciality(userInfo.getSpeciality().getName());
        userInfoDto.setGrade(userInfo.getGrade());
        userInfoDto.setPhone(userInfo.getPhone());

        if (userInfo.getEnrollment()!= null) {
            userInfoDto.setTestStart(dateFormat.format(userInfo.getEnrollment().getEnrollment().getTestStart()));
            userInfoDto.setTestEnd(dateFormat.format(userInfo.getEnrollment().getEnrollment().getTestEnd()));
            userInfoDto.setEnrollmentId(userInfo.getEnrollment().getId());
        }

        return userInfoDto;
    }
}
