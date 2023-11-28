package com.healthApi.demo.controller;

import com.healthApi.demo.entity.ProBound;
import com.healthApi.demo.exception.ProBoundNotCreatedException;
import com.healthApi.demo.exception.ProBoundNotFoundException;
import com.healthApi.demo.service.ProBoundService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
    @RestController
    @RequestMapping("/probound")
    public class ProBoundController {
        @Autowired
        private ProBoundService proBoundService;

        public ProBoundController(ProBoundService proBoundService){
            this.proBoundService = proBoundService;
        }

        @PostMapping("/save")
        public ResponseEntity<ProBound> saveProBound(@RequestBody ProBound proBound){
            try{
                proBoundService.createProBound(proBound);
                URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(proBound.getId()).toUri();
                return ResponseEntity.created(uri).body(proBound);

            }catch (RuntimeException e){
                throw new ProBoundNotCreatedException("Could not create proBound, please check the payload again");
            }
        }

        @GetMapping("/{medicId}")
        public ResponseEntity<ProBound> findProBoundByMedicId(@PathVariable Long medicId){
            try {
                ProBound proBound = proBoundService.getProBoundByID(medicId);
                return ResponseEntity.ok().body(proBound);
            }catch (EntityNotFoundException e){
                throw new ProBoundNotFoundException("Could not find proBound, please check id again");
            }
        }

        @GetMapping()
        public ResponseEntity<List<ProBound>> findAll(){
            try {
                List<ProBound> proBound = proBoundService.findAll();
                return ResponseEntity.ok().body(proBound);
            }catch (RuntimeException e){
                throw new ProBoundNotFoundException("Could not find list of proBound, please check id again");
            }
        }

//        @PutMapping("/update/{id}")
//        public ResponseEntity<ProBound> updateProBound(@PathVariable Long id, @RequestBody ProBound proBound){
//            try {
//                ProBound proBound1 = proBoundService.updateProBound(id, proBound);
//                return ResponseEntity.ok().body(proBound1);
//            }catch (EntityNotFoundException e){
//                throw new ProBoundNotFoundException("Could not find list of proBound, please check id again");
//            }
//
//        }
//
//        @DeleteMapping("/{id}")
//        public ResponseEntity deleteProBoundById(@PathVariable(value = "id") Long id){
//            try {
//                proBoundService.deleteProBound(id);
//                return ResponseEntity.noContent().build();
//
//            }catch (EmptyResultDataAccessException e){
//                throw new ProBoundNotFoundException("Could not find proBound, please check id again");
//            }
//        }

    }
