package com.ncTestService.repositories;

import com.ncTestService.models.TestUser;
import org.springframework.data.repository.CrudRepository;

public interface TestUserRepository extends CrudRepository<TestUser, Long> {
}
