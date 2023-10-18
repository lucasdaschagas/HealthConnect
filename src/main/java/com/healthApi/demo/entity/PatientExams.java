package com.healthApi.demo.entity;

import com.healthApi.demo.entity.pk.PatientExamPk;

public class PatientExams {
    private PatientExamPk id = new PatientExamPk();
    private Integer quantity;

    public PatientExams(){}

    public PatientExams(Patient patient, Exams exams, Integer quantity){
        id.setPatient(patient);
        id.setExams(exams);
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setExams(Exams exams){
        id.setExams(exams);
    }
    public Exams getExams(){
        return id.getExams();
    }

    public void setPatient(Patient patient){
        id.setPatient(patient);
    }
    public Patient getPatient(){
        return id.getPatient();
    }
}
