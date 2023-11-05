package com.healthApi.demo.service;

import com.healthApi.demo.entity.Exams;
import com.healthApi.demo.exception.ProductNotFoundException;
import com.healthApi.demo.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.logging.Logger;

@Service
public class ExamsService {

    @Autowired
    private ExamRepository repository;
    private final Logger logger = Logger.getLogger(ExamsService.class.getName());



    private Exams getExamByID(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new ProductNotFoundException("Product do not exist, please, try another id"));
    }

    private Page<Exams> findAll(Pageable pageable){
        logger.info("Finding all exams");

        return repository.findAll(pageable);
    }

    private Exams createExam(Exams exams){
        return repository.save(exams);
    }

    private Exams updateExam(Long id, Exams exams){
        Exams entity = repository.getReferenceById(id);
        updateData(entity,exams);
        return entity;
    }

    private void deleteExam(Long id){
        repository.deleteById(id);
    }

    private void updateData(Exams entity, Exams obj) {
        entity.setName(obj.getName());
        entity.setExamDate(LocalDateTime.parse(obj.getExamDate()));
    }



}