package com.dhabits.code.lifeplanner.lifeplanner.db.repository;

import com.dhabits.code.lifeplanner.lifeplanner.db.model.MainDirection;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MainDirectionRepository extends CrudRepository<MainDirection, UUID> {
}
