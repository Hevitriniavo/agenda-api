package com.fresh.coding.agendaapi.services;

import com.fresh.coding.agendaapi.dtos.StudentLevelDto;

import java.util.List;

/**
 * Service interface for managing student levels.
 * Provides methods for creating and retrieving student levels.
 */
public interface StudentLevelService {

    /**
     * Creates multiple student levels.
     *
     * @param studentLevels a list of {@link StudentLevelDto} objects representing the student levels to be created.
     * @return a list of {@link StudentLevelDto} objects representing the created student levels.
     */
    List<StudentLevelDto> createManyStudentsLevels(List<StudentLevelDto> studentLevels);

    /**
     * Retrieves all student levels.
     *
     * @return a list of {@link StudentLevelDto} objects representing all student levels in the system.
     */
    List<StudentLevelDto> findAllStudentsLevels();
}
