package com.example.hospital_management_system.controller;

import com.example.hospital_management_system.model.Doctor;
import com.example.hospital_management_system.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.findAll();
    }

    @GetMapping("/{id}")
    public Doctor getDoctor(@PathVariable Long id) {
        return doctorService.findById(id);
    }

    @PostMapping
    public Doctor createDoctor(@Valid @RequestBody Doctor doctor) {
        return doctorService.save(doctor);
    }

    @GetMapping("/specialization/{specialization}")
    public List<Doctor> getBySpecialization(@PathVariable String specialization) {
        return doctorService.findBySpecialization(specialization);
    }

    @GetMapping("/department/{department}")
    public List<Doctor> getByDepartment(@PathVariable String department) {
        return doctorService.findByDepartment(department);
    }

    @GetMapping("/search/{name}")
    public List<Doctor> searchByName(@PathVariable String name) {
        return doctorService.findByNameContaining(name);
    }

    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable Long id, @Valid @RequestBody Doctor doctor) {
        doctor.setId(id);
        return doctorService.save(doctor);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        doctorService.deleteById(id);
    }
}