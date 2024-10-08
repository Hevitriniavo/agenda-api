package com.fresh.coding.agendaapi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a classroom entity within the application.
 * This class maps to the 'classroom' table in the database.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Builder
public class Classroom {

    /**
     * The unique identifier for the classroom.
     * This field is auto-generated by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The room number of the classroom.
     */
    private String roomNumber;

    /**
     * The maximum number of students the classroom can accommodate.
     */
    private Integer capacity;

    /**
     * A textual description of the classroom.
     */
    @Column(columnDefinition = "TEXT")
    private String description;

    /**
     * A list of course schedules associated with this classroom.
     * This relationship is mapped by the 'classroom' field in the {@link CourseSchedule} entity.
     * The list is initialized to an empty list by default.
     * Cascade type ALL and orphanRemoval are enabled, which means that all changes to the course schedules
     * are cascaded to the database, and orphaned schedules are removed.
     */
    @Builder.Default
    @ToString.Exclude
    @OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CourseSchedule> courseSchedules = new ArrayList<>();

    /**
     * The timestamp when the classroom was created.
     * Automatically set before persisting the entity.
     */
    private LocalDateTime createdAt;

    /**
     * The timestamp when the classroom was last updated.
     * Automatically updated before updating the entity.
     */
    private LocalDateTime updatedAt;

    /**
     * Sets the creation timestamp to the current time if it is not already set.
     * Also sets the updated timestamp to the current time before persisting the entity.
     */
    @PrePersist
    public void beforeCreate() {
        if (createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
        if (updatedAt == null) {
            this.updatedAt = LocalDateTime.now();
        }
    }

    /**
     * Updates the timestamp to the current time before updating the entity.
     */
    @PreUpdate
    public void beforeUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
