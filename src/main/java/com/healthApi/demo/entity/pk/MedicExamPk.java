package com.healthApi.demo.entity.pk;

import com.healthApi.demo.entity.Exams;
import com.healthApi.demo.entity.Medic;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable
public class MedicExamPk {
    @ManyToOne
    @JoinColumn(name = "medic_id")
    private Medic medic;
    @ManyToOne
    @JoinColumn(name = "exams_id")
    private Exams exams;

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
        if (!(o instanceof MedicExamPk that)) return false;

        if (!Objects.equals(medic, that.medic)) return false;
        return Objects.equals(exams, that.exams);
    }

    @Override
    public int hashCode() {
        int result = medic != null ? medic.hashCode() : 0;
        result = 31 * result + (exams != null ? exams.hashCode() : 0);
        return result;
    }
}
