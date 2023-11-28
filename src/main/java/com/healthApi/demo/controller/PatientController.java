package com.healthApi.demo.controller;

import com.healthApi.demo.entity.Patient;
import com.healthApi.demo.exception.ObjectAlreadyExists;
import com.healthApi.demo.exception.PatientNotCreatedException;
import com.healthApi.demo.exception.PatientNotFoundException;
import com.healthApi.demo.service.PatientService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/save")
    public ResponseEntity<Patient> savePatient(@RequestBody Patient patient) throws ObjectAlreadyExists {
        try {
            patientService.createPatient(patient);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(patient.getId()).toUri();
            return ResponseEntity.created(uri).body(patient);

        } catch (RuntimeException e) {
            throw new PatientNotCreatedException("Could not create patient, please check the payload again" + e.getMessage());

        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> findPatientById(@PathVariable(value = "id") Long id) {
        try {
            Patient patient = patientService.getPatientByID(id);
            return ResponseEntity.ok().body(patient);
        } catch (EntityNotFoundException e) {
            throw new PatientNotFoundException("Could not find exam, please check id again");
        }
    }

    @GetMapping()
    public ResponseEntity<List<Patient>> findAll() {
        try {
            List<Patient> patient = patientService.findAll();
            return ResponseEntity.ok().body(patient);
        } catch (RuntimeException e) {
            throw new PatientNotFoundException("Could not find list of patient, please check id again");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
        try {
            Patient patient1 = patientService.updatePatient(id, patient);
            return ResponseEntity.ok().body(patient1);
        } catch (EntityNotFoundException e) {
            throw new PatientNotFoundException("Could not find list of patient, please check id again");
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePatientById(@PathVariable(value = "id") Long id) {
        try {
            patientService.deletePatient(id);
            return ResponseEntity.noContent().build();

        } catch (EmptyResultDataAccessException e) {
            throw new PatientNotFoundException("Could not find exam, please check id again");
        }
    }

}
