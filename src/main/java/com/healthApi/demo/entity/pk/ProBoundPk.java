package com.healthApi.demo.entity.pk;

import com.healthApi.demo.entity.Exams;
import com.healthApi.demo.entity.Medic;
import com.healthApi.demo.entity.Patient;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable
public class ProBoundPk {
    @ManyToOne
    @JoinColumn(name = "medic_id")
    private Medic medic;
    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exams exams;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;


    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medic getMedic() {
        return medic;
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
    }

    public Exams getExams() {
        return exams;
    }

    public void setExams(Exams exams) {
        this.exams = exams;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProBoundPk that = (ProBoundPk) o;
        return Objects.equals(medic, that.medic) && Objects.equals(exams, that.exams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medic, exams);
    }


}
