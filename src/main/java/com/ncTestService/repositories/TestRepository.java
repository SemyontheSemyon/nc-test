package com.ncTestService.repositories;

import com.ncTestService.models.Test;
import com.ncTestService.models.User;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository<Test, Long> {
    Test findByUser(User user);
}
