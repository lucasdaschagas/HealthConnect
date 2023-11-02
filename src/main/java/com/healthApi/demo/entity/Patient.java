package com.healthApi.demo.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_patient")
public class Patient {
    @Id
    private Long id;
    private String name;
    private String email;
    private String disease;
    @Embedded
    private Adress adress ;

    @OneToMany(mappedBy = "id.patient")
    @Column(name = "exams_to_make")
    private Set<MedicPatientExams> exams = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }
}
