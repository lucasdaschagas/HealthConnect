package com.healthApi.demo.controller;

import com.healthApi.demo.entity.ProBound;
import com.healthApi.demo.exception.ProBoundNotCreatedException;
import com.healthApi.demo.exception.ProBoundNotFoundException;
import com.healthApi.demo.service.ProBoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
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
            ProBound proBound = proBoundService.getProBoundByID(medicId);
            if (proBound == null){
                throw new ProBoundNotFoundException("This bound was removed or never existed, please insert valid medicId");
            }
            else {
                return ResponseEntity.ok().body(proBound);
            }
        }

        @GetMapping()
        public ResponseEntity<List<ProBound>> findAll(){
            List<ProBound> proBound = proBoundService.findAll();
            if (!proBound.stream().findAny().isEmpty()){
            try {
                return ResponseEntity.ok().body(proBound);
            }catch (RuntimeException e){
                throw new ProBoundNotFoundException("Could not find list of proBound, please check id again");
            }
        } else {
                throw new ProBoundNotFoundException("List never existed or wiped out, please insert data");}
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
        @DeleteMapping("/delete/{id}")
        public ResponseEntity deleteProBoundById(@PathVariable(value = "id") Long id){
            try {
                proBoundService.deleteProBound(id);
                return ResponseEntity.noContent().build();

            }catch (EmptyResultDataAccessException e){
                throw new ProBoundNotFoundException("Could not find proBound, please check id again");
            }
        }

    }
