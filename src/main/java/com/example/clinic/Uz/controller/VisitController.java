package com.example.clinic.Uz.controller;

import com.example.clinic.Uz.service.VisitService;
import com.example.clinic.Uz.model.Visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class VisitController {
    @Autowired
    private VisitService visitService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Visit visit){
        Visit result = visitService.create(visit);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id){
        Visit result = visitService.get(id);
        return ResponseEntity.ok(result);
    }
    @PutMapping("/{id}")
    ResponseEntity<?> update(@PathVariable("id") Integer id,
                             @RequestBody Visit visit){
        Visit result = visitService.update(id,visit);
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable("id") Integer id){
        boolean result = visitService.delete(id);
        return ResponseEntity.ok(result);
    }
}
