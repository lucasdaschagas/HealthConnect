package com.healthApi.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.healthApi.demo.entity.pk.ProBoundPk;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_ProBounds")
public class ProBound {
    @Column(unique = true)
    private Long identification;
    @EmbeddedId
    private final ProBoundPk idPk = new ProBoundPk();
    private Integer quantity;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd 'T' HH:mm:ss 'Z'" , timezone = "GMT")
    @Column(name = "emission_date", nullable = false, columnDefinition = "TIMESTAMP")
    private Instant emission;

    public ProBound(){}

    public ProBound(Exams exams, Patient patient, Medic medic, Integer quantity, Instant emission) {

        idPk.setExams(exams);
        idPk.setPatient(patient);
        idPk.setMedic(medic);
        this.quantity = quantity;
        this.emission = emission;
    }


    public Long getIdentification(){
        return this.identification;
    }
    public void setIdentification(Long identification){
        this.identification=identification;
    }
    public ProBoundPk getId() {
        return idPk;
    }
    @JsonIgnore
    public Exams getExam(){
        return idPk.getExams();
    }
    public void setExam(Exams exams){
        idPk.setExams(exams);
    }
    @JsonIgnore
    public Patient getPatient(){
        return idPk.getPatient();
    }
    public void setPatient(Patient patient){
        idPk.setPatient(patient);
    }
    @JsonIgnore
    public Medic getMedic(){
        return idPk.getMedic();
    }
    public void setMedic(Medic medic){
        idPk.setMedic(medic);
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
        ProBound that = (ProBound) o;
        return Objects.equals(idPk, that.idPk) && Objects.equals(quantity, that.quantity)
                && Objects.equals(emission, that.emission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPk, quantity, emission);
    }
}
