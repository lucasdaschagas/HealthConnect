package com.healthApi.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_exams")
public class Exams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "exam_name", nullable = false,unique = true)
    private String name;

    @Column(name = "exam_date", nullable = false, columnDefinition = "VARCHAR")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private String examDate;

    @OneToMany(mappedBy = "idPk.exams")
    @Column(name = "exams_by_medics")
    private Set<ProBound> medics = new HashSet<>();


    public Exams() {
    }

    public Exams(String name, LocalDateTime examDate) {
        this.name = name;
        this.examDate = formatData(examDate);

    }

    public String formatData(LocalDateTime data){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return data.format(formatter);
    }
    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    @JsonIgnore
    public Set<Medic> getMedics() {
        Set<Medic> set = new HashSet<>();
        for (ProBound x : medics){
            set.add(x.getMedic());
        }
        return set;
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
