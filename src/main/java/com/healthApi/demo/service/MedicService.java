package com.healthApi.demo.service;
import com.healthApi.demo.entity.Medic;
import com.healthApi.demo.exception.ProductNotFoundException;
import com.healthApi.demo.repository.MedicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.logging.Logger;

public class MedicService {
    @Autowired
    private MedicRepository repository;
    private final Logger logger = Logger.getLogger(MedicService.class.getName());


    private Medic getMedicByID(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new ProductNotFoundException("Product do not exist, please, try another id"));
    }

    private Page<Medic> findAll(Pageable pageable) {
        logger.info("Finding all Medic");

        return repository.findAll(pageable);
    }

    private Medic createMedic(Medic Medic) {
        return repository.save(Medic);
    }

    private Medic updateMedic(Long id, Medic Medic) {
        Medic entity = repository.getReferenceById(id);
        updateData(entity, Medic);
        return entity;
    }

    private void deleteMedic(Long id) {
        repository.deleteById(id);
    }

    private void updateData(Medic entity, Medic obj) {
        entity.setName(obj.getName());
        entity.setCrm(obj.getCrm());
        entity.setRole(obj.getRoles());

    }
}