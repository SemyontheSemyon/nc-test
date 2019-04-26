package com.ncTestService.repositories;

import com.ncTestService.models.Test;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository<Test, Long> {
}
