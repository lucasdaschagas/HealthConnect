package com.healthApi.demo.entity.pk;

import com.healthApi.demo.entity.Exams;
import com.healthApi.demo.entity.Patient;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable
public class PatientExamPk {
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "exams_id")
    private Exams exams;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
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
        if (!(o instanceof PatientExamPk that)) return false;

        if (!Objects.equals(patient, that.patient)) return false;
        return Objects.equals(exams, that.exams);
    }

    @Override
    public int hashCode() {
        int result = patient != null ? patient.hashCode() : 0;
        result = 31 * result + (exams != null ? exams.hashCode() : 0);
        return result;
    }
}
