package com.fresh.coding.agendaapi.repositories;

import com.fresh.coding.agendaapi.entities.StudentLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for accessing {@link StudentLevel} entities from the database.
 * Extends {@link JpaRepository} to provide CRUD operations and additional querying capabilities.
 */
@Repository
public interface StudentLevelRepository extends JpaRepository<StudentLevel, Long> {
    // No additional methods are defined here. Inherits standard CRUD operations and
    // querying capabilities from JpaRepository.
}
