package com.healthApi.demo.entity;

import com.healthApi.demo.enums.Roles;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_medic")
public class Medic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer crm;
    @Column(nullable = false)
    private String name;
    private Integer role;

    @OneToMany(mappedBy = "id.medic")
    @Column(name = "exams_made")
    private Set<MedicPatientExams> exams = new HashSet<>();


    public Medic() {
    }

    public Medic(Integer crm, String name, Roles role, Set<MedicPatientExams> exams) {
        this.crm = crm;
        this.name = name;
        setRole(role);
        this.exams = exams;
    }

    private void setRole(Roles role) {
        if (role != null) {
            this.role = role.getCode();
        }
    }
    public String getName() {
        return name;
    }
    public Integer getCrm() {
        return crm;
    }
    public Roles getRoles(){
        return Roles.valueOf(role);
    }



    public void setCrm(Integer crm) {
        this.crm = crm;
    }



    public void setName(String name) {
        this.name = name;
    }

    public Set<Exams> getExams() {
        Set<Exams> examsSet = new HashSet<>();
        for (MedicPatientExams x : exams){
            examsSet.add(x.getExam());
        }
        return examsSet;
    }

    public void setExams(Set<MedicPatientExams> exams) {
        this.exams = exams;
    }
}
