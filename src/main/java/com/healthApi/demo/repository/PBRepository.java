package com.healthApi.demo.repository;

import com.healthApi.demo.entity.ProBound;
import com.healthApi.demo.entity.pk.ProBoundPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PBRepository extends JpaRepository<ProBound, ProBoundPk> {
    @Query("SELECT pb FROM ProBound pb WHERE pb.idPk.medic.id = :medicId")
    ProBound findBoundByMedicId(@Param("medicId") Long medicId);

    @Query("SELECT MAX(p.identification) FROM ProBound p")
    Long findByMaxIdentification();
}
