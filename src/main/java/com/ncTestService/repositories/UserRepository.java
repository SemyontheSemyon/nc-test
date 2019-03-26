package com.ncTestService.repositories;

import com.ncTestService.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
