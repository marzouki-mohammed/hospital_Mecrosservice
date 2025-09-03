package com.smartclinic.doctor;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

/**
 * Doctor entity represents a medical doctor in the Smart Clinic system.
 */
@Entity
@Table(name = "doctor")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Full name is required")
    @Column(nullable = false)
    private String fullName;

    @NotBlank(message = "Specialty is required")
    @Column(nullable = false)
    private String specialty;

    @NotBlank(message = "Phone number is required")
    @Column(nullable = false)
    private String phone;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    @Column(nullable = false, unique = true)
    private String email;
}
