package com.example.clinic.Uz.service;

import com.example.clinic.Uz.repository.PatientRepository;
import com.example.clinic.Uz.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient create(Patient patient){
        patient.setStatus(true);
        patient.setCreatedAt(LocalDateTime.now());
        patientRepository.save(patient);
        return patient;
    }
    public Patient get(Integer id) {
        Optional<Patient> optional = patientRepository.findById(id);
        if (optional.isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }
        return optional.get();
    }


    public Patient update(Integer id, Patient patient) {
        Patient old = get(id);
        old.setName(patient.getName());
        old.setUpdateAt(patient.getUpdateAt());
        patientRepository.save(old);
        return old;
    }

    public boolean delete(Integer id) {
        Patient patient = get(id);
        patientRepository.save(patient);
        return true;
    }
}
