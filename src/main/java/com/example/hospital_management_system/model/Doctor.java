package com.example.hospital_management_system.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "doctors")
@Data
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Doctor name is required")
    private String name;

    @Email(message = "Please provide a valid email")
    @Column(unique = true)
    private String email;

    private String phone;

    @NotBlank(message = "Specialization is required")
    private String specialization;

    private String licenseNumber;
    private String department;
}