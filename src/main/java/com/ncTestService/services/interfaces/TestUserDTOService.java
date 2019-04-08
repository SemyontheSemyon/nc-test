package com.ncTestService.services.interfaces;


import com.ncTestService.DTO.TestUserDTO;
import com.ncTestService.models.TestUser;

import java.util.List;

public interface TestUserDTOService {

    List<TestUser> makeTestUsers(TestUserDTO dto);

}
