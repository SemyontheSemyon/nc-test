package com.ncTestService.repositories;

import com.ncTestService.models.DBStatus;
import org.springframework.data.repository.CrudRepository;

public interface DBStatusRepository extends CrudRepository<DBStatus, Long> {
}
