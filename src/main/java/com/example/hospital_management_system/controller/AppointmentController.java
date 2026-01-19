package com.example.hospital_management_system.controller;

import com.example.hospital_management_system.model.Appointment;
import com.example.hospital_management_system.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public List<Appointment> getAll() {
        return appointmentService.getAllAppointments();
    }

    @PostMapping
    public Appointment create(@Valid @RequestBody Appointment appointment) {
        return appointmentService.saveAppointment(appointment);
    }
}