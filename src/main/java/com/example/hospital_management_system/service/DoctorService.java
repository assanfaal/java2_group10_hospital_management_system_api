package com.example.hospital_management_system.service;

import com.example.hospital_management_system.model.Doctor;
import com.example.hospital_management_system.repository.DoctorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found"));
    }

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(Long id, Doctor details) {
        Doctor doctor = getDoctorById(id);
        doctor.setName(details.getName());
        doctor.setSpecialization(details.getSpecialization());
        doctor.setEmail(details.getEmail());
        doctor.setDepartment(details.getDepartment());
        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(Long id) {
        doctorRepository.delete(getDoctorById(id));
    }
}