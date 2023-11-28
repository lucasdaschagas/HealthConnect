package com.healthApi.demo.controller;

import com.healthApi.demo.entity.Medic;
import com.healthApi.demo.exception.MedicNotCreatedException;
import com.healthApi.demo.exception.MedicNotFoundException;
import com.healthApi.demo.service.MedicService;
import com.healthApi.demo.service.MedicService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/medic")
public class MedicController {
        @Autowired
        private MedicService medicService;

        public MedicController(MedicService medicService){
            this.medicService = medicService;
        }

        @PostMapping("/save")
        public ResponseEntity<Medic> saveMedic(@RequestBody Medic medic){
            try{
                medicService.createMedic(medic);
                URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(medic.getId()).toUri();
                return ResponseEntity.created(uri).body(medic);

            }catch (RuntimeException e){
                throw new MedicNotCreatedException("Could not create exam, please check the payload again");
            }
        }

        @GetMapping("/{id}")
        public ResponseEntity<Medic> findMedicById(@PathVariable(value = "id") Long id){
            try {
                Medic medic = medicService.getMedicByID(id);
                return ResponseEntity.ok().body(medic);
            }catch (EntityNotFoundException e){
                throw new MedicNotFoundException("Could not find exam, please check id again");
            }
        }

        @GetMapping()
        public ResponseEntity<List<Medic>> findAll(){
            try {
                List<Medic> medic = medicService.findAll();
                return ResponseEntity.ok().body(medic);
            }catch (RuntimeException e){
                throw new MedicNotFoundException("Could not find list of medic, please check id again");
            }
        }

        @PutMapping("/update/{id}")
        public ResponseEntity<Medic> updateMedic(@PathVariable Long id, @RequestBody Medic medic){
            try {
                Medic medic1 = medicService.updateMedic(id, medic);
                return ResponseEntity.ok().body(medic1);
            }catch (EntityNotFoundException e){
                throw new MedicNotFoundException("Could not find list of medic, please check id again");
            }

        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity deleteMedicById(@PathVariable(value = "id") Long id){
            try {
                medicService.deleteMedic(id);
                return ResponseEntity.noContent().build();

            }catch (EmptyResultDataAccessException e){
                throw new MedicNotFoundException("Could not find exam, please check id again");
            }
        }

    }
