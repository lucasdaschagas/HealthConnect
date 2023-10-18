package com.healthApi.demo.entity;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "tb_patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, name = "birth_date")
    private String birthDay;
    @Column(nullable = false)
    private String disease;
    @Column(nullable = false)
    @OneToMany(mappedBy = "id.exams")
    private final Set<PatientExams> exams = new HashSet<>();

    @Column(name = "responsible_medics")
    private final Set<Medic> responsibleMedics = new HashSet<>();

    public Patient(String name, String email, String birthDay, String disease) {
        this.name = name;
        this.email = email;
        this.birthDay = birthDay;
        this.disease = disease;
    }

    public Patient(){}

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

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public Set<PatientExams> getExams() {
        return exams;
    }


    public Long getId(){
        return this.id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;

        Patient patient = (Patient) o;

        if (!Objects.equals(id, patient.id)) return false;
        if (!Objects.equals(name, patient.name)) return false;
        if (!Objects.equals(email, patient.email)) return false;
        if (!Objects.equals(birthDay, patient.birthDay)) return false;
        if (!Objects.equals(disease, patient.disease)) return false;
        return  (!Objects.equals(Exams, patient.Exams));

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (birthDay != null ? birthDay.hashCode() : 0);
        result = 31 * result + (disease != null ? disease.hashCode() : 0);
        result = 31 * result + (Exams != null ? Exams.hashCode() : 0);
        return result;
    }
}
