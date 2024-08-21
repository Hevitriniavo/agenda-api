package com.fresh.coding.agendaapi.controllers;

import com.fresh.coding.agendaapi.dtos.StudentLevelDto;
import com.fresh.coding.agendaapi.services.StudentLevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing student levels within the application.
 * Provides endpoints for creating and retrieving student levels.
 */
@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/students/levels")
public class StudentLevelController {

    /**
     * Service used to handle operations related to student levels.
     */
    private final StudentLevelService studentLevelService;

    /**
     * Endpoint to create multiple student levels.
     *
     * @param studentLevels a list of {@link StudentLevelDto} objects representing the student levels to be created.
     * @return a list of {@link StudentLevelDto} objects representing the created student levels.
     */
    @PostMapping
    public List<StudentLevelDto> createManyStudentsLevels(@RequestBody List<StudentLevelDto> studentLevels) {
        return studentLevelService.createManyStudentsLevels(studentLevels);
    }

    /**
     * Endpoint to retrieve all student levels.
     *
     * @return a list of {@link StudentLevelDto} objects representing all student levels in the system.
     */
    @GetMapping
    public List<StudentLevelDto> getAllStudentsLevels() {
        return studentLevelService.findAllStudentsLevels();
    }
}
