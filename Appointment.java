package com.smartclinic.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDateTime;

/**
 * Represents an appointment between a doctor and a patient.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    @NotNull(message = "Doctor must be specified")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    @NotNull(message = "Patient must be specified")
    private Patient patient;

    @NotNull(message = "Start time must be specified")
    @Future(message = "Start time must be in the future")
    private LocalDateTime startAt;

    @NotNull(message = "End time must be specified")
    @Future(message = "End time must be in the future")
    private LocalDateTime endAt;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    // Enum pour le statut du rendez-vous
    public enum AppointmentStatus {
        SCHEDULED,
        COMPLETED,
        CANCELED
    }
}
