package com.healthApi.demo.entity;

import com.healthApi.demo.entity.pk.MedicExamPk;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_medic_exam")
public class MedicExam {

    @EmbeddedId
    private MedicExamPk id = new MedicExamPk();
    private Integer quantity;

    public MedicExam(Medic medic, Exams exams, Integer quantity) {
        id.setMedic(medic);
        id.setExams(exams);
        this.quantity = quantity;
    }
    public MedicExam(){}

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public void setMedic(Medic medic){
        id.setMedic(medic);
    }
    public Medic getMedic(){
        return id.getMedic();
    }


    public void setExam(Exams exams){
        id.setExams(exams);
    }
    public Exams getExams(){
       return id.getExams();
    }
}
