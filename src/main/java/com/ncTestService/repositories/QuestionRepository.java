package com.ncTestService.repositories;

import com.ncTestService.models.Question;
import com.ncTestService.models.Speciality;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question, Long> {

    Iterable<Question> findBySpeciality(Speciality speciality);
    Iterable<Question> findAllBySpeciality(Speciality speciality);

}
