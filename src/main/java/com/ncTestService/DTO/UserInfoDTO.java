package com.ncTestService.DTO;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
public class UserInfoDTO {

    @NotEmpty
    private String studentStatus;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String city;

    @NotEmpty
    private String phone;

    private Integer grade;

    private String university;

    private String department;

    private String speciality;

    private String testStart;

    private String testEnd;

    private Long enrollmentId;
}
