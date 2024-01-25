package com.dhabits.code.lifeplanner.lifeplanner.db.repository;

import com.dhabits.code.lifeplanner.lifeplanner.db.model.MainDirection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface MainDirectionRepository extends CrudRepository<MainDirection, UUID> {

}
