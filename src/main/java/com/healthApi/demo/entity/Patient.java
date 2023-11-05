package com.healthApi.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_patient")
@JsonPropertyOrder({"id", "name","email","disease","adress"})
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @JsonProperty("e-mail")
    private String email;
    private String disease;
    @Embedded
    private Adress adress ;


    @OneToMany(mappedBy = "id.patient")
    @Column(name = "exams_to_make")
    private Set<ProBound> exams = new HashSet<>();

    public Patient(String name, String email, String disease, Adress adress) {
        this.name = name;
        this.email = email;
        this.disease = disease;
        this.adress = adress;
    }

    public Patient() {
    }

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


    public Set<Exams> getExams() {
        Set<Exams> examsSet = new HashSet<>();
        for (ProBound x : exams){
            examsSet.add(x.getExam());
        }
        return examsSet;
    }
}
