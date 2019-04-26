package com.ncTestService.repositories;

import com.ncTestService.models.Question;
import com.ncTestService.models.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {

    Iterable<Question> findAllBySpeciality(Speciality speciality);

}
