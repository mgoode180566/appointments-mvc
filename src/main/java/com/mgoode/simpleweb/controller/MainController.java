package com.mgoode.simpleweb.controller;

import com.mgoode.simpleweb.model.Appointment;
import com.mgoode.simpleweb.service.AppointmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
        model.addAttribute("appointments", appointmentService.getAllAppointments());
        return "appointments";
    }

    @PostMapping("/appointments/create")
    public ModelAndView addAppointment( Model model, @ModelAttribute("appointment") Appointment appointment ) {
        log.info("Add an appointment");
        appointmentService.addAppointment(appointment);
        ModelAndView modelAndView = new ModelAndView("/appointments");
        modelAndView.addObject("appointments", appointmentService.getAllAppointments());
        return modelAndView;
    }

}
