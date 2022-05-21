package com.example.clinic.Uz.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter

@Entity
@Table(name = ("doctors"))
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @ManyToOne
    @JoinColumn(name = ("doctor_id"), insertable = false, updatable = false)
    private Integer id;
    
    private String name;

    private String surname;

    private String direction;

    private Integer experience;

    private boolean status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
