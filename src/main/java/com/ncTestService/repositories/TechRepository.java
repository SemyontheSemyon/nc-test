package com.ncTestService.repositories;

import com.ncTestService.models.Tech;
import org.springframework.data.repository.CrudRepository;

public interface TechRepository extends CrudRepository<Tech, Long> {
}
