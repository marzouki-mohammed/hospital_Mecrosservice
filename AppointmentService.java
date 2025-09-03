package com.smartclinic.services;

import com.smartclinic.models.Appointment;
import com.smartclinic.models.Doctor;
import com.smartclinic.repositories.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Service for managing appointments in the Smart Clinic Management System.
 */
@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    // ------------------ CRUD / Booking ------------------

    /**
     * Book a new appointment.
     *
     * @param appointment Appointment object to save
     * @return Saved Appointment
     */
    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    /**
     * Update an existing appointment.
     *
     * @param appointment Appointment object with updated fields
     * @return Updated Appointment
     */
    public Appointment updateAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    /**
     * Delete an appointment by ID.
     *
     * @param id ID of the appointment
     */
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    /**
     * Retrieve an appointment by ID.
     *
     * @param id ID of the appointment
     * @return Appointment object
     */
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id " + id));
    }

    // ------------------ New Method: Retrieve appointments by doctor and date ------------------

    /**
     * Get all appointments for a specific doctor on a given date.
     *
     * @param doctor Doctor object
     * @param date   LocalDate of appointments
     * @return List of appointments for that doctor on the specified date
     */
    public List<Appointment> getAppointmentsByDoctorAndDate(Doctor doctor, LocalDate date) {
        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = date.atTime(23, 59, 59);
        return appointmentRepository.findByDoctorAndStartAtBetween(doctor, startOfDay, endOfDay);
    }

    /**
     * Get all appointments for a specific patient.
     *
     * @param patientId ID of the patient
     * @return List of appointments
     */
    public List<Appointment> getAppointmentsByPatientId(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }
}
