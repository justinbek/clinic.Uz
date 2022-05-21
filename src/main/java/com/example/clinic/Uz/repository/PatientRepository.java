package com.example.clinic.Uz.repository;

import com.example.clinic.Uz.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer > {
}
