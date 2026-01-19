package com.example.hospital_management_system.service;

import com.example.hospital_management_system.model.Patient;
import com.example.hospital_management_system.repository.PatientRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    // Get all patients
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Get a single patient by ID (Used for GET /api/patients/1)
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
    }

    // Create a new patient
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    // Update an existing patient (Used for PUT /api/patients/1)
    public Patient updatePatient(Long id, Patient details) {
        Patient patient = getPatientById(id); // Reuses the method above to find the patient

        patient.setName(details.getName());
        patient.setEmail(details.getEmail());
        patient.setPhoneNumber(details.getPhoneNumber());
        patient.setAddress(details.getAddress());

        return patientRepository.save(patient);
    }

    // Delete a patient (Used for DELETE /api/patients/1)
    public void deletePatient(Long id) {
        Patient patient = getPatientById(id);
        patientRepository.delete(patient);
    }
}
