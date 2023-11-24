package com.healthApi.demo.service;

import com.healthApi.demo.entity.Patient;
import com.healthApi.demo.entity.ProBound;
import com.healthApi.demo.exception.ProductNotFoundException;
import com.healthApi.demo.repository.PBRepository;
import com.healthApi.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.logging.Logger;

public class ProBoundService {
    @Autowired
    private PBRepository repository;
    private final Logger logger = Logger.getLogger(PatientService.class.getName());


    private ProBound getProBoundByID(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new ProductNotFoundException("Product do not exist, please, try another id"));
    }

    private Page<ProBound> findAll(Pageable pageable) {
        logger.info("Finding all Patient");

        return repository.findAll(pageable);
    }

    private ProBound createProBound(ProBound proBound) {
        return repository.save(proBound);
    }

    private ProBound updateProBound(Long id, ProBound proBound) {
        ProBound entity = repository.getReferenceById(id);
        updateData(entity, proBound);
        return entity;
    }

    private void deleteProBound(Long id) {
        repository.deleteById(id);
    }

    private void updateData(ProBound entity, ProBound obj) {
    entity.setEmission(obj.getEmission());
    entity.setMedic(obj.getMedic());
    entity.setExam(obj.getExam());
    entity.setPatient(obj.getPatient());
    entity.setQuantity(obj.getQuantity());
    }
}

