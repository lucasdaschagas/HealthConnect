package com.healthApi.demo.service;
import com.healthApi.demo.entity.Medic;
import com.healthApi.demo.exception.ProductNotFoundException;
import com.healthApi.demo.repository.MedicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.logging.Logger;

public class MedicService {
    @Autowired
    private MedicRepository repository;
    private final Logger logger = Logger.getLogger(MedicService.class.getName());


    public Medic getMedicByID(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new ProductNotFoundException("Product do not exist, please, try another id"));
    }

    public List<Medic> findAll() {
        logger.info("Finding all Medic");

        return repository.findAll();
    }

    public Medic createMedic(Medic Medic) {
        return repository.save(Medic);
    }

    public Medic updateMedic(Long id, Medic Medic) {
        Medic entity = repository.getReferenceById(id);
        updateData(entity, Medic);
        return entity;
    }

    public void deleteMedic(Long id) {
        repository.deleteById(id);
    }

    private void updateData(Medic entity, Medic obj) {
        entity.setName(obj.getName());
        entity.setCrm(obj.getCrm());
        entity.setRole(obj.getRoles());

    }
}