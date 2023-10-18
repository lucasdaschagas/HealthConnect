package com.healthApi.demo.repository;

import com.healthApi.demo.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
