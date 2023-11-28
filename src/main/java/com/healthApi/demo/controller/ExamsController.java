package com.healthApi.demo.controller;

import com.healthApi.demo.entity.Exams;
import com.healthApi.demo.exception.ExamNotCreatedException;
import com.healthApi.demo.exception.ExamNotFoundException;
import com.healthApi.demo.service.ExamsService;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/exams")
public class ExamsController {
    @Autowired
    private ExamsService examsService;

    public ExamsController(ExamsService examsService){
        this.examsService = examsService;
    }

    @PostMapping("/save")
    public ResponseEntity<Exams> saveExam(@RequestBody Exams exams){
        try{
            examsService.createExam(exams);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(exams.getId()).toUri();
            return ResponseEntity.created(uri).body(exams);

        }catch (RuntimeException e){
            throw new ExamNotCreatedException("Could not create exam, please check the payload again");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exams> findExamById(@PathVariable(value = "id") Long id){
        try {
            Exams exams = examsService.getExamByID(id);
            return ResponseEntity.ok().body(exams);
        }catch (EntityNotFoundException e){
            throw new ExamNotFoundException("Could not find exam, please check id again");
        }
    }

    @GetMapping()
    public ResponseEntity<List<Exams>> findAll(){
        try {
            List<Exams> exams = examsService.findAll();
            return ResponseEntity.ok().body(exams);
        }catch (RuntimeException e){
            throw new ExamNotFoundException("Could not find list of exams, please check id again");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Exams> updateExams(@PathVariable Long id, @RequestBody Exams exams){
        try {
           Exams exams1 = examsService.updateExam(id, exams);
           return ResponseEntity.ok().body(exams1);
        }catch (EntityNotFoundException e){
            throw new ExamNotFoundException("Could not find list of exams, please check id again");
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteExamById(@PathVariable(value = "id") Long id){
        try {
            examsService.deleteExam(id);
            return ResponseEntity.noContent().build();

        }catch (EmptyResultDataAccessException e){
            throw new ExamNotFoundException("Could not find exam, please check id again");
        }
    }


}
