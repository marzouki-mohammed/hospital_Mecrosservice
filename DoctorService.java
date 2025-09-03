package com.smartclinic.services;

import com.smartclinic.models.Appointment;
import com.smartclinic.models.Doctor;
import com.smartclinic.repositories.AppointmentRepository;
import com.smartclinic.repositories.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service for managing doctors in the Smart Clinic Management System.
 */
@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final AppointmentRepository appointmentRepository;
    private final PasswordEncoder passwordEncoder;

    // ------------------ CRUD Operations ------------------

    public Doctor createDoctor(Doctor doctor) {
        doctor.setPassword(passwordEncoder.encode(doctor.getPassword()));
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // ------------------ New Method: Validate login ------------------

    public boolean validateLogin(String email, String rawPassword) {
        Optional<Doctor> doctorOpt = doctorRepository.findByEmail(email);
        return doctorOpt.map(doctor -> passwordEncoder.matches(rawPassword, doctor.getPassword())).orElse(false);
    }

    // ------------------ New Method: Get available time slots ------------------

    public List<LocalTime> getAvailableTimeSlots(Long doctorId, LocalDate date) {
        Optional<Doctor> doctorOpt = doctorRepository.findById(doctorId);
        if (doctorOpt.isEmpty()) return new ArrayList<>();

        Doctor doctor = doctorOpt.get();

        // Exemple : horaires fixes de 9h à 17h, toutes les 30 minutes
        List<LocalTime> allSlots = new ArrayList<>();
        LocalTime start = LocalTime.of(9, 0);
        LocalTime end = LocalTime.of(17, 0);
        while (!start.isAfter(end.minusMinutes(30))) {
            allSlots.add(start);
            start = start.plusMinutes(30);
        }

        // Retirer les créneaux déjà pris
        List<Appointment> appointments = appointmentRepository.findByDoctorAndStartAtBetween(
                doctor,
                date.atStartOfDay(),
                date.atTime(23, 59, 59)
        );

        appointments.forEach(app -> allSlots.remove(app.getStartAt().toLocalTime()));

        return allSlots;
    }
}
