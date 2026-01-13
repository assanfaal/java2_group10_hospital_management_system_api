package com.example.hospital_management_system.repository;

import com.example.hospital_management_system.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findBySpecialization(String specialization);
    List<Doctor> findByNameContaining(String name);
    List<Doctor> findByDepartment(String department);
}