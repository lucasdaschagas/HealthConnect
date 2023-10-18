package com.healthApi.demo.repository;

import com.healthApi.demo.entity.Exams;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exams,Long> {
}
