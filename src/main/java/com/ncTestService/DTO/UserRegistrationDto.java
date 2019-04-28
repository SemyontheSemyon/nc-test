package com.ncTestService.DTO;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class UserRegistrationDto {

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String password;
}
