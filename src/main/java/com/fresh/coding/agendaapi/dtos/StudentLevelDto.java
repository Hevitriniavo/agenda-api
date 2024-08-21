package com.fresh.coding.agendaapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Data Transfer Object (DTO) for transferring student level data.
 * This class is used to encapsulate the data related to student levels
 * when transferring between different layers of the application.
 */
@Getter
@AllArgsConstructor
@Setter
public class StudentLevelDto implements Serializable {

    /**
     * The unique identifier for the student level.
     */
    private Long id;

    /**
     * The name of the student level.
     */
    private String levelName;

    /**
     * A textual description of the student level.
     */
    private String description;
}
