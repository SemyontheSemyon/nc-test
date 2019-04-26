package com.ncTestService.repositories;

import com.ncTestService.models.QuestionType;
import org.springframework.data.repository.CrudRepository;

public interface QuestionTypeRepository extends CrudRepository<QuestionType, Long> {

    QuestionType findByName(String name);

}
