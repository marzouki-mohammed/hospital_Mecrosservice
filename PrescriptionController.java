package com.smartclinic.controllers;

import com.smartclinic.models.Prescription;
import com.smartclinic.services.PrescriptionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing prescriptions.
 */
@RestController
@RequestMapping("/api/prescriptions")
@RequiredArgsConstructor
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    // ------------------ CRUD Operations ------------------

    @GetMapping
    public ResponseEntity<List<Prescription>> getAllPrescriptions() {
        return ResponseEntity.ok(prescriptionService.getAllPrescriptions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prescription> getPrescriptionById(@PathVariable Long id) {
        return ResponseEntity.ok(prescriptionService.getPrescriptionById(id));
    }

    /**
     * Create a prescription with token and user validation.
     *
     * @param user         The user performing the action
     * @param token        The authentication token
     * @param prescription Prescription object
     * @return Saved prescription
     */
    @PostMapping("/{user}/{token}")
    @PreAuthorize("hasAnyRole('DOCTOR','ADMIN')")
    public ResponseEntity<?> createPrescription(
            @PathVariable String user,
            @PathVariable String token,
            @Valid @RequestBody Prescription prescription) {

        if (!prescriptionService.isValidToken(user, token)) {
            return ResponseEntity.status(401).body("Invalid or expired token.");
        }

        Prescription savedPrescription = prescriptionService.createPrescription(prescription, token);
        return ResponseEntity.ok(savedPrescription);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('DOCTOR','ADMIN')")
    public ResponseEntity<Prescription> updatePrescription(
            @PathVariable Long id,
            @Valid @RequestBody Prescription prescription) {

        Prescription updatedPrescription = prescriptionService.updatePrescription(id, prescription);
        return ResponseEntity.ok(updatedPrescription);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deletePrescription(@PathVariable Long id) {
        prescriptionService.deletePrescription(id);
        return ResponseEntity.noContent().build();
    }
}
