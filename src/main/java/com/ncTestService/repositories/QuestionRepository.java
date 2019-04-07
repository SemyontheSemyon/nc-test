package com.ncTestService.repositories;

import com.ncTestService.models.Enrollment;
import com.ncTestService.models.Question;
import com.ncTestService.models.Speciality;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question, Long> {

    List<Question> findBySpeciality(Speciality speciality);

}
