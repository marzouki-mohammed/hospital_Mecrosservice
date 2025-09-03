package com.smartclinic.prescription;

import com.smartclinic.patient.Patient;
import com.smartclinic.doctor.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing prescriptions in the Smart Clinic system.
 */
@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    private final PrescriptionRepository prescriptionRepository;

    @Autowired
    public PrescriptionController(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    // Get all prescriptions
    @GetMapping
    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

    // Get a prescription by ID
    @GetMapping("/{id}")
    public ResponseEntity<Prescription> getPrescriptionById(@PathVariable Long id) {
        return prescriptionRepository.findById(id)
                .map(prescription -> ResponseEntity.ok().body(prescription))
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new prescription
    @PostMapping
    public Prescription createPrescription(@RequestBody Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    // Update an existing prescription
    @PutMapping("/{id}")
    public ResponseEntity<Prescription> updatePrescription(@PathVariable Long id,
                                                           @RequestBody Prescription prescriptionDetails) {
        return prescriptionRepository.findById(id).map(prescription -> {
            prescription.setDoctor(prescriptionDetails.getDoctor());
            prescription.setPatient(prescriptionDetails.getPatient());
            prescription.setMedication(prescriptionDetails.getMedication());
            prescription.setDosage(prescriptionDetails.getDosage());
            prescription.setInstructions(prescriptionDetails.getInstructions());
            Prescription updatedPrescription = prescriptionRepository.save(prescription);
            return ResponseEntity.ok(updatedPrescription);
        }).orElse(ResponseEntity.notFound().build());
    }

    // Delete a prescription
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrescription(@PathVariable Long id) {
        return prescriptionRepository.findById(id).map(prescription -> {
            prescriptionRepository.delete(prescription);
            return ResponseEntity.noContent().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
