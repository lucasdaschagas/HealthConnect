package com.healthApi.demo.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_medic")
public class Medic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer crm;
    @Column(nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    private Integer role;

    @OneToMany(mappedBy = "id.exams")
    @Column(name = "exams_made")
    private Set<MedicPatientExams> exams = new HashSet<>();



}
