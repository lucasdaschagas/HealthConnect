package com.healthApi.demo.repository;

import com.healthApi.demo.entity.Medic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicRepository extends JpaRepository<Medic, Long> {
}
