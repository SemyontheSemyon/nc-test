package com.ncTestService.repositories;

import com.ncTestService.models.User;
import com.ncTestService.models.UserInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {

    Optional<UserInfo> findByUser(User user);

}
