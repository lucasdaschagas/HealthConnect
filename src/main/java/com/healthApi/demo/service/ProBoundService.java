package com.healthApi.demo.service;

import com.healthApi.demo.entity.Medic;
import com.healthApi.demo.entity.Patient;
import com.healthApi.demo.entity.ProBound;
import com.healthApi.demo.exception.ProductNotFoundException;
import com.healthApi.demo.repository.MedicRepository;
import com.healthApi.demo.repository.PBRepository;
import com.healthApi.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
@Service
public class ProBoundService {
    @Autowired
    private PBRepository repository;
    @Autowired
    private MedicRepository medicRepository;
    private final Logger logger = Logger.getLogger(ProBound.class.getName());


    public ProBound getProBoundByID(Long id) {
//        Long idMedic = bound.getMedic().getId();

        return repository.findBoundByMedicId(id);
    }

    public List<ProBound> findAll() {
        logger.info("Finding all Bounds");

        return repository.findAll();
    }

    public ProBound createProBound(ProBound proBound) {
        Long lastIdentification = repository.findByMaxIdentification();
        if (lastIdentification == null) {
            proBound.setIdentification(1L);
        } else {
            proBound.setIdentification(lastIdentification + 1);
        }

        return repository.save(proBound);
    }

//    public ProBound updateProBound(Long id, ProBound proBound) {
//        ProBound entity = repository.getReferenceById(id);
//        updateData(entity, proBound);
//        return repository.save(entity);
//    }
//
    public void deleteProBound(Long id) {
        repository.deleteByIdentification(id);
    }

    private void updateData(ProBound entity, ProBound obj) {
    entity.setEmission(obj.getEmission());
    entity.setMedic(obj.getMedic());
    entity.setExam(obj.getExam());
    entity.setPatient(obj.getPatient());
    entity.setQuantity(obj.getQuantity());
    }
}

