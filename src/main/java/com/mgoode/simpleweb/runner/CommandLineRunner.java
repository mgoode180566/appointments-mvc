package com.mgoode.simpleweb.runner;

import com.mgoode.simpleweb.model.Appointment;
import com.mgoode.simpleweb.service.AppointmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.text.SimpleDateFormat;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner{

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AppointmentService appointmentService;

    @Override
    public void run(String... args) throws Exception {

        String pattern = "dd/mm/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        log.info("Add some appointments");
        appointmentService.addAppointment(new Appointment("An appointment 1", Date.valueOf("2020-08-31")));
        appointmentService.addAppointment(new Appointment("An appointment 2", Date.valueOf("2021-02-01")));
        appointmentService.addAppointment(new Appointment("An appointment 3", Date.valueOf("1998-01-10")));

    }
}
