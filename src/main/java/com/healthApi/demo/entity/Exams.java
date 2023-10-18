package com.healthApi.demo.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_exams")
public class Exams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String examName;
    @OneToMany(mappedBy = "id.exams")
    @Column(name = "responsible_medic")
    private Set<MedicExam> medicExamSet;
    private List<Patient> patients;
}
