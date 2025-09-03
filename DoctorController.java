package com.smartclinic.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing doctors in the Smart Clinic system.
 */
@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    // Get all doctors
    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // Get a doctor by ID
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
        return doctorRepository.findById(id)
                .map(doctor -> ResponseEntity.ok().body(doctor))
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new doctor
    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    // Update an existing doctor
    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @RequestBody Doctor doctorDetails) {
        return doctorRepository.findById(id).map(doctor -> {
            doctor.setFullName(doctorDetails.getFullName());
            doctor.setSpecialty(doctorDetails.getSpecialty());
            doctor.setPhone(doctorDetails.getPhone());
            doctor.setEmail(doctorDetails.getEmail());
            Doctor updatedDoctor = doctorRepository.save(doctor);
            return ResponseEntity.ok(updatedDoctor);
        }).orElse(ResponseEntity.notFound().build());
    }

    // Delete a doctor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        return doctorRepository.findById(id).map(doctor -> {
            doctorRepository.delete(doctor);
            return ResponseEntity.noContent().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
