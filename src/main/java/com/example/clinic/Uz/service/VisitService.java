package com.example.clinic.Uz.service;

import com.example.clinic.Uz.repository.VisitRepository;
import com.example.clinic.Uz.model.Visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class VisitService {

    @Autowired
    private VisitRepository visitRepository;

    public Visit create(Visit visit) {
        visit.setStatus(true);
        visit.setCreatedAt(LocalDateTime.now());
        visitRepository.save(visit);
        return visit;
    }

    public Visit get(Integer id) {
        Optional<Visit> optional = visitRepository.findById(id);
        if(optional.isEmpty()){
            throw new IllegalArgumentException("User not found");
        }
        return optional.get();
    }

    public Visit update(Integer id, Visit visit) {
        Visit old = get(id);
        old.setDiagnos(visit.getDiagnos());
        old.setUpdateAt(visit.getUpdateAt());
        visitRepository.save(old);
        return old;
    }

    public boolean delete(Integer id) {
        Visit visit = get(id);
        visitRepository.save(visit);
        return true;
    }
}
