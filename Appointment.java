package com.smartclinic.appointment;

import com.smartclinic.doctor.Doctor;
import com.smartclinic.patient.Patient;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDateTime;

/**
 * Appointment entity represents a scheduled appointment between a doctor and a patient.
 */
@Entity
@Table(name = "appointment")
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
    @NotNull(message = "Doctor is required")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    @NotNull(message = "Patient is required")
    private Patient patient;

    @NotNull(message = "Start time is required")
    @Column(nullable = false)
    private LocalDateTime startAt;

    @NotNull(message = "End time is required")
    @Column(nullable = false)
    private LocalDateTime endAt;

    @Column(nullable = false)
    private String status; // e.g., SCHEDULED, COMPLETED, CANCELED
}
