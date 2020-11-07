package com.mgoode.simpleweb.controller;

import com.mgoode.simpleweb.model.Appointment;
import com.mgoode.simpleweb.service.AppointmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class MainController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    AppointmentService appointmentService;

    public MainController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @RequestMapping("/appointments")
    public String getAllAppointments( Model model ) {
        log.info("Get all appointments");
        Iterable<Appointment> appointments=appointmentService.getAllAppointments();
        model.addAttribute("appointments", appointmentService.getAllAppointments());
        return "appointments";
    }

    @PostMapping("/appointments/create")
    public ModelAndView addAppointment(@ModelAttribute("appointment") @Valid Appointment appointment, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("/appointments");
            modelAndView.addObject("appointments", appointmentService.getAllAppointments());
            return modelAndView;
        } else {
            log.info("Add an appointment" + appointment.getDescription() + "   " + appointment.getDate().toString());
            appointmentService.addAppointment(appointment);
            ModelAndView modelAndView = new ModelAndView("/appointments");
            modelAndView.addObject("appointments", appointmentService.getAllAppointments());
            return modelAndView;
        }

    }

}
