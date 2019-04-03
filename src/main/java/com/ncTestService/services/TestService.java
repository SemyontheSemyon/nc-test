package com.ncTestService.services;


import com.ncTestService.models.Test;
import com.ncTestService.models.TestFormat;
import com.ncTestService.models.TestUser;

import java.util.List;

public interface TestService {

    List<Test> getAllTests();
    Test getTest(Long id);
    void addTest(Test test);
    void updateTest(Test test);
    void deleteTest(Test test);

    List<Test> getAllTestUsers();
    Test getTestUser(Long id);
    void addTestUser(TestUser testUser);
    void updateTestUser(TestUser testUser);
    void deleteTestUser(TestUser testUser);



}
