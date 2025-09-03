package com.smartclinic.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Patient entity.
 * Provides CRUD operations and JPA query methods.
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    // Vous pouvez ajouter des méthodes personnalisées si nécessaire
    // Exemple : trouver un patient par email
    Patient findByEmail(String email);
}
