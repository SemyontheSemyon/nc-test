package com.ncTestService.repositories;

import com.ncTestService.models.Enrollment;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Enrollment, Long> {
}
