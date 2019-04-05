package com.ncTestService.repositories;

import com.ncTestService.models.*;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {

    List<UserInfo> findByFirstNameAndLastName(String firstName, String lastName);
    List<UserInfo> findByStudentStatus(StudentStatus studentStatus);
    List<UserInfo> findByCity(City city);
    List<UserInfo> findBySpeciality(Speciality speciality);
    List<UserInfo> findByEnrollment(Enrollment enrollment);
    Optional<UserInfo> findByUser(User user);

}
