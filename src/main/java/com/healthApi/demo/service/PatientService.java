package com.healthApi.demo.service;

import com.healthApi.demo.entity.Patient;
import com.healthApi.demo.exception.ObjectAlreadyExists;
import com.healthApi.demo.exception.ProductNotFoundException;
import com.healthApi.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;
@Service
public class PatientService {
    @Autowired
    private PatientRepository repository;
    private final Logger logger = Logger.getLogger(PatientService.class.getName());

    @Transactional(readOnly = true)
    public Patient getPatientByID(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new ProductNotFoundException("Product do not exist, please, try another id"));
    }
    @Transactional(readOnly = true)
    public List<Patient> findAll() {
        logger.info("Finding all Patient");

        return repository.findAll();
    }
    @Transactional
    public Patient createPatient(Patient patient) {
        return repository.save(patient);
    }
    @Transactional
    public Patient updatePatient(Long id, Patient Patient) {
        Patient entity = repository.getReferenceById(id);
        updateData(entity, Patient);
        return repository.save(entity);
    }
    @Transactional
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