package com.healthApi.demo.repository;

import com.healthApi.demo.entity.ProBound;
import com.healthApi.demo.entity.pk.ProBoundPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PBRepository extends JpaRepository<ProBound, ProBoundPk> {
    @Transactional(readOnly = true)
    @Query("SELECT pb FROM ProBound pb WHERE pb.idPk.medic.id = :medicId")
    ProBound findBoundByMedicId(@Param("medicId") Long medicId);

    @Transactional(readOnly = true)
    @Query("SELECT MAX(p.identification) FROM ProBound p")
    Long findByMaxIdentification();

    @Modifying
    @Transactional
    @Query("DELETE FROM ProBound p WHERE p.identification = :id")
    void deleteByIdentification(@Param("id") Long id);

}
