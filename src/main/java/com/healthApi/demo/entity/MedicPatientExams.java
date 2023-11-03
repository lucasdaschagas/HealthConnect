package com.healthApi.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.healthApi.demo.entity.pk.MedicPatientExamsPk;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_medic_patient_exams")
public class MedicPatientExams {

    @EmbeddedId
    private final MedicPatientExamsPk id = new MedicPatientExamsPk();
    private Integer quantity;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd 'T' HH:mm:ss 'Z'" , timezone = "GMT")
    private Instant emission;

    public MedicPatientExams(){}

    public MedicPatientExams(Exams exams,Patient patient, Medic medic, Integer quantity, Instant emission) {
        id.setExams(exams);
        id.setPatient(patient);
        id.setMedic(medic);
        this.quantity = quantity;
        this.emission = emission;
    }


    public Exams getExam(){
        return id.getExams();
    }
    public void setExam(Exams exams){
        id.setExams(exams);
    }
    public Patient getPatient(){
        return id.getPatient();
    }
    public void setPatient(Patient patient){
        id.setPatient(patient);
    }

    public Medic getMedic(){
        return id.getMedic();
    }
    public void setMedic(Medic medic){
        id.setMedic(medic);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Instant getEmission() {
        return emission;
    }

    public void setEmission(Instant emission) {
        this.emission = emission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicPatientExams that = (MedicPatientExams) o;
        return Objects.equals(id, that.id) && Objects.equals(quantity, that.quantity)
                && Objects.equals(emission, that.emission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, emission);
    }
}
