package com.fresh.coding.agendaapi.services.impl;

import com.fresh.coding.agendaapi.dtos.StudentLevelDto;
import com.fresh.coding.agendaapi.entities.StudentLevel;
import com.fresh.coding.agendaapi.repositories.StudentLevelRepository;
import com.fresh.coding.agendaapi.services.StudentLevelService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the service for managing student levels.
 * Provides methods for creating and retrieving student levels.
 * Implements the {@link StudentLevelService} interface.
 */
@Service
@RequiredArgsConstructor
public class StudentLevelServiceImpl implements StudentLevelService {

    /**
     * Repository for accessing student level data.
     */
    private final StudentLevelRepository studentLevelRepository;

    /**
     * Creates multiple student levels by saving them to the database.
     *
     * @param studentLevels List of student levels to be created.
     * @return List of created student levels as DTOs.
     */
    @Transactional
    @Override
    public List<StudentLevelDto> createManyStudentsLevels(List<StudentLevelDto> studentLevels) {
        List<StudentLevel> newStudentLevels = new ArrayList<>();

        for (StudentLevelDto studentLevelDto : studentLevels) {
            StudentLevel studentLevel = toStudentLevel(studentLevelDto);
            newStudentLevels.add(studentLevel);
        }

        List<StudentLevel> studentLevelSummarized = studentLevelRepository.saveAll(newStudentLevels);
        return studentLevelSummarized
                .stream().map(this::toStudentLevelDto)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves all existing student levels from the database.
     *
     * @return List of all student levels as DTOs.
     */
    @Override
    public List<StudentLevelDto> findAllStudentsLevels() {
        return studentLevelRepository
                .findAll()
                .stream().map(this::toStudentLevelDto)
                .collect(Collectors.toList());
    }

    /**
     * Converts a {@link StudentLevel} entity into a {@link StudentLevelDto}.
     *
     * @param studentLevel The student level entity to convert.
     * @return The corresponding student level DTO.
     */
    private StudentLevelDto toStudentLevelDto(StudentLevel studentLevel) {
        return new StudentLevelDto(
                studentLevel.getId(),
                studentLevel.getLevelName(),
                studentLevel.getDescription()
        );
    }

    /**
     * Converts a {@link StudentLevelDto} into a {@link StudentLevel} entity.
     *
     * @param studentLevelDto The student level DTO to convert.
     * @return The corresponding student level entity.
     */
    private StudentLevel toStudentLevel(StudentLevelDto studentLevelDto) {
        return StudentLevel.builder()
                .id(studentLevelDto.getId())
                .levelName(studentLevelDto.getLevelName())
                .description(studentLevelDto.getDescription())
                .build();
    }
}
