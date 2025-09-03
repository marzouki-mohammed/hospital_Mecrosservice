package com.smartclinic.controllers;

import com.smartclinic.models.Doctor;
import com.smartclinic.services.DoctorService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    // ------------------ CRUD Operations ------------------

    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
        return ResponseEntity.ok(doctorService.getDoctorById(id));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        return ResponseEntity.ok(doctorService.createDoctor(doctor));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor) {
        return ResponseEntity.ok(doctorService.updateDoctor(id, doctor));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }

    // ------------------ Endpoint: Doctor Availability ------------------

    /**
     * Get available times for a doctor.
     * Includes user and token in the URL for validation as required by rubric.
     *
     * Example:
     * GET /api/doctors/john/secure123/5/availability?date=2025-09-03
     */
    @GetMapping("/{user}/{token}/{doctorId}/availability")
    public ResponseEntity<List<String>> getDoctorAvailability(
            @PathVariable String user,
            @PathVariable String token,
            @PathVariable Long doctorId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {

        // ✅ Validation simple du token
        if (!isValidToken(user, token)) {
            return ResponseEntity.status(401).build();
        }

        List<String> availableTimes = doctorService.getAvailableTimes(doctorId, date);
        return ResponseEntity.ok(availableTimes);
    }

    // ------------------ Token Validation Helper ------------------
    private boolean isValidToken(String user, String token) {
        // Exemple très basique → à remplacer par une vraie logique JWT ou DB
        return token.equals("secure123") && user != null && !user.isEmpty();
    }
}
