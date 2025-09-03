package com.smartclinic.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service layer for managing appointments in the Smart Clinic system.
 */
@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    // Get all appointments
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    // Get an appointment by ID
    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    // Create a new appointment
    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    // Update an existing appointment
    public Optional<Appointment> updateAppointment(Long id, Appointment appointmentDetails) {
        return appointmentRepository.findById(id).map(appointment -> {
            appointment.setDoctor(appointmentDetails.getDoctor());
            appointment.setPatient(appointmentDetails.getPatient());
            appointment.setStartAt(appointmentDetails.getStartAt());
            appointment.setEndAt(appointmentDetails.getEndAt());
            appointment.setStatus(appointmentDetails.getStatus());
            return appointmentRepository.save(appointment);
        });
    }

    // Delete an appointment
    public boolean deleteAppointment(Long id) {
        return appointmentRepository.findById(id).map(appointment -> {
            appointmentRepository.delete(appointment);
            return true;
        }).orElse(false);
    }
}
