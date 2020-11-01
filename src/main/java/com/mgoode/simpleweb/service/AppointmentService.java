package com.mgoode.simpleweb.service;

import com.mgoode.simpleweb.model.Appointment;
import com.mgoode.simpleweb.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Iterable<Appointment> getAllAppointments() {
        return appointmentRepository.findAllByOrderByDateAsc();
    }

    public void addAppointment( Appointment appointment ) {
        appointmentRepository.save(appointment);
    }

}
