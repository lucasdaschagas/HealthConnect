package com.healthApi.demo.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_exams")
public class Exams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "exam_name", nullable = false)
    private String name;
    @Column(name = "exam_date", nullable = false)
    private Date examDate;
    @OneToMany(mappedBy = "id.medic")
    @Column(name = "exams_by_medics")
    private Set<MedicPatientExams> medics = new HashSet<>();
}
