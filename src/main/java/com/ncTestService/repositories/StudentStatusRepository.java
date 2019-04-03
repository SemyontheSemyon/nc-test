package com.ncTestService.repositories;

import com.ncTestService.models.StudentStatus;
import org.springframework.data.repository.CrudRepository;

public interface StudentStatusRepository extends CrudRepository<StudentStatus, Long> {

    StudentStatus findByName(String name);
}
