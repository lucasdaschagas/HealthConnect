package com.healthApi.demo.entity;

import com.healthApi.demo.enums.Roles;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_medics")
public class Medic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String crm;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Roles role;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(name = "patients")
    private List<Patient> patientList;
    @OneToMany(mappedBy = "id.medic")
    private final Set<MedicExam> examsRequested = new HashSet<>();




}
