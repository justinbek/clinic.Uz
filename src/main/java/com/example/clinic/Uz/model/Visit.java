package com.example.clinic.Uz.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter

@Entity
@Table(name = ("visits"))
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer patient_id;

    private Integer doctor_id;

    private String diagnos;

    private boolean status;

    private LocalDateTime createdAt;

    private LocalDateTime updateAt;

}
