package com.healthApi.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
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
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime examDate;

    @OneToMany(mappedBy = "id.exams")
    @Column(name = "exams_by_medics")
    private Set<MedicPatientExams> medics = new HashSet<>();

    public Exams() {
    }

    public Exams(String name, LocalDateTime examDate) {
        this.name = name;
        this.examDate = examDate;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDateTime examDate) {
        this.examDate = examDate;
    }

    public Set<MedicPatientExams> getMedics() {
        return medics;
    }

    public void setMedics(Set<MedicPatientExams> medics) {
        this.medics = medics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exams exams = (Exams) o;
        return Objects.equals(id, exams.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
