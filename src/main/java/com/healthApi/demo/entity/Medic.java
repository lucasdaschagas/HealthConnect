package com.healthApi.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
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
    @Column(nullable = false,unique = true)
    private Integer crm;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private Integer role;

    @OneToMany(mappedBy = "idPk.medic")
    @Column(name = "exams_made")
    private Set<ProBound> exams = new HashSet<>();


    public Medic() {
    }

    public Medic(Integer crm, String name, Roles role) {
        this.crm = crm;
        this.name = name;
        setRole(role);
    }


    public void setRole(Object role) {
        if (role instanceof Roles) {
            this.role = ((Roles) role).getCode();
        } else if (role instanceof String) {
            Roles foundRoles = Roles.fromString((String) role);
            this.role = foundRoles.getCode();
        }
    }

    public Long getId() {
        return id;
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

    @JsonIgnore
    public Set<Exams> getExams() {
        Set<Exams> examsSet = new HashSet<>();
        for (ProBound x : exams){
            examsSet.add(x.getExam());
        }
        return examsSet;
    }

    public void setExams(Set<ProBound> exams) {
        this.exams = exams;
    }
}
