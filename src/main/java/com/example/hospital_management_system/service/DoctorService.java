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

    public Doctor save(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    public Doctor findById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    public List<Doctor> findBySpecialization(String specialization) {
        return doctorRepository.findBySpecialization(specialization);
    }

    public List<Doctor> findByNameContaining(String name) {
        return doctorRepository.findByNameContaining(name);
    }

    public List<Doctor> findByDepartment(String department) {
        return doctorRepository.findByDepartment(department);
    }

    public void deleteById(Long id) {
        doctorRepository.deleteById(id);
    }
}