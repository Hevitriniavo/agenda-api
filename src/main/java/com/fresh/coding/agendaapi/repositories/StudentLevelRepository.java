package com.fresh.coding.agendaapi.repositories;

import com.fresh.coding.agendaapi.entities.StudentLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentLevelRepository extends JpaRepository<StudentLevel, Long> {
}
