package com.ncTestService.repositories;

import com.ncTestService.models.Test;
import com.ncTestService.models.TestUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TestUserRepository extends CrudRepository<TestUser, Long> {
    List<TestUser> findByTest(Test test);
}
