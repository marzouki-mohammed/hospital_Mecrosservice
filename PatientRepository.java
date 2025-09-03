package com.smartclinic.repositories;

import com.smartclinic.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for managing Patient entities.
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    /**
     * Find a patient by email.
     *
     * @param email Patient's email
     * @return Optional containing the Patient if found
     */
    Optional<Patient> findByEmail(String email);

    /**
     * Check if a patient exists with the given email.
     *
     * @param email Patient's email
     * @return true if exists, false otherwise
     */
    boolean existsByEmail(String email);

    /**
     * Find a patient by ID and return only active patients (if using an active flag).
     *
     * @param id Patient ID
     * @return Optional containing the Patient
     */
    Optional<Patient> findByIdAndActiveTrue(Long id);
}
