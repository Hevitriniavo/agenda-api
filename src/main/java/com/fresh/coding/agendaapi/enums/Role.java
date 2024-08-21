package com.fresh.coding.agendaapi.enums;

/**
 * Represents the role of a user within the application.
 * This enum is used to define different user roles with specific permissions and responsibilities.
 */
public enum Role {

    /**
     * Administrator role.
     * Typically has the highest level of access and permissions in the application.
     */
    ADMIN,

    /**
     * Professor role.
     * Represents users who are professors and may have permissions related to course management and teaching.
     */
    PROFESSOR,

    /**
     * Student role.
     * Represents users who are students and may have permissions related to course enrollment and participation.
     */
    STUDENT
}
