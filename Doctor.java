package com.smartclinic.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

/**
 * Represents a doctor in the Smart Clinic Management System.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private String specialty;

    private String phone;

    private String email;

    // Nouveau champ : liste des créneaux horaires disponibles
    @ElementCollection
    @CollectionTable(name = "doctor_available_times", joinColumns = @JoinColumn(name = "doctor_id"))
    @Column(name = "available_time")
    private List<String> availableTimes;
}
