package com.healthApi.demo.service;

import com.healthApi.demo.entity.Patient;
import com.healthApi.demo.exception.ProductNotFoundException;
import com.healthApi.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.logging.Logger;

public class PatientService {
    @Autowired
    private PatientRepository repository;
    private final Logger logger = Logger.getLogger(PatientService.class.getName());


    public Patient getPatientByID(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new ProductNotFoundException("Product do not exist, please, try another id"));
    }

    public List<Patient> findAll() {
        logger.info("Finding all Patient");

        return repository.findAll();
    }

    public Patient createPatient(Patient Patient) {
        return repository.save(Patient);
    }

    public Patient updatePatient(Long id, Patient Patient) {
        Patient entity = repository.getReferenceById(id);
        updateData(entity, Patient);
        return entity;
    }

    public void deletePatient(Long id) {
        repository.deleteById(id);
    }

    private void updateData(Patient entity, Patient obj) {
        entity.setName(obj.getName());
        entity.setDisease(obj.getDisease());
        entity.setEmail(obj.getEmail());
        entity.setAdress(obj.getAdress());

    }
}