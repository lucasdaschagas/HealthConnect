package com.healthApi.demo.service;

import com.healthApi.demo.entity.Exams;
import com.healthApi.demo.exception.ProductNotFoundException;
import com.healthApi.demo.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

@Service
public class ExamsService {

    @Autowired
    private ExamRepository repository;
    public final Logger logger = Logger.getLogger(ExamsService.class.getName());


    @Transactional(readOnly = true)
    public Exams getExamByID(Long id) {
        Exams exams = repository.findById(id).orElseThrow(() ->
                new ProductNotFoundException("Product do not exist, please, try another id"));

        return exams;
    }

    @Transactional(readOnly = true)
    public List<Exams> findAll(){
        logger.info("Finding all exams");

        return repository.findAll();
    }
    @Transactional
    public void createExam(Exams exams){
        repository.save(exams);
    }

    @Transactional
    public Exams updateExam(Long id, Exams exams){
        Exams entity = repository.getReferenceById(id);
        updateData(entity,exams);
        return entity;
    }
    @Transactional
    public void deleteExam(Long id){
        repository.deleteById(id);
    }

    private void updateData(Exams entity, Exams obj) {
        entity.setName(obj.getName());
        entity.setExamDate(LocalDateTime.parse(obj.getExamDate()));
    }



}