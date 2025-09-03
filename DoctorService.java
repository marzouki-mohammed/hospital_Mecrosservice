package com.smartclinic.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service layer for managing doctors in the Smart Clinic system.
 */
@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    // Get all doctors
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // Get a doctor by ID
    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    // Create a new doctor
    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    // Update an existing doctor
    public Optional<Doctor> updateDoctor(Long id, Doctor doctorDetails) {
        return doctorRepository.findById(id).map(doctor -> {
            doctor.setFullName(doctorDetails.getFullName());
            doctor.setSpecialty(doctorDetails.getSpecialty());
            doctor.setPhone(doctorDetails.getPhone());
            doctor.setEmail(doctorDetails.getEmail());
            return doctorRepository.save(doctor);
        });
    }

    // Delete a doctor
    public boolean deleteDoctor(Long id) {
        return doctorRepository.findById(id).map(doctor -> {
            doctorRepository.delete(doctor);
            return true;
        }).orElse(false);
    }
}
