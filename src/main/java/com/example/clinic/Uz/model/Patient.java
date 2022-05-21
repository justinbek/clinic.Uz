package com.example.clinic.Uz.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter

@Entity
@Table(name = ("patients"))
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @ManyToOne
    @JoinColumn(name = ("patient_id"), insertable = false, updatable = false )
    private Integer id;

    private String name;

    private String surname;

    private Timestamp birthday;

    private String contact;

    private Integer age;

    private boolean status;

    private LocalDateTime createdAt;
    private LocalDateTime updateAt;

}
