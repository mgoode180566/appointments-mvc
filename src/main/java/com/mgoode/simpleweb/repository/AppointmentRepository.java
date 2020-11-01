package com.mgoode.simpleweb.repository;

import com.mgoode.simpleweb.model.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository  extends CrudRepository<Appointment, Long> {
    Iterable<Appointment> findAllByOrderByDateAsc();
}
