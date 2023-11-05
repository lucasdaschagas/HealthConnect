package com.healthApi.demo.repository;

import com.healthApi.demo.entity.ProBound;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MPERepository extends JpaRepository<ProBound,Long> {
}
