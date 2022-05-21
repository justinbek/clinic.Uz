package com.example.clinic.Uz.service;

import com.example.clinic.Uz.repository.DoctorRepository;
import com.example.clinic.Uz.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service

public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor create(Doctor doctor) {
        doctor.setStatus(true);
        doctor.setCreatedAt(LocalDateTime.now());
        doctorRepository.save(doctor);
        return doctor;
    }

    public Doctor get(Integer id) {
        Optional<Doctor> optional = doctorRepository.findById(id);
        if (optional.isEmpty()){
            throw new IllegalArgumentException("User not found");
        }

        return optional.get();
    }

    public Doctor update(Integer id, Doctor doctor) {
        Doctor old = get(id);
        old.setName(doctor.getName());
        old.setUpdatedAt(doctor.getUpdatedAt());
        doctorRepository.save(old);
        return old;
    }

    public boolean delete(Integer id) {
        Doctor doctor = get(id);
        doctorRepository.save(doctor);
        return true;
    }
}
