package com.ncTestService.repositories;

import com.ncTestService.models.UserTech;
import org.springframework.data.repository.CrudRepository;

public interface UserTechRepository extends CrudRepository<UserTech, Long> {
}
