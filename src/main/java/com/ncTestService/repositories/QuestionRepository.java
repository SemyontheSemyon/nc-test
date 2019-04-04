package com.ncTestService.repositories;

import com.ncTestService.models.Enrollment;
import com.ncTestService.models.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {
}
