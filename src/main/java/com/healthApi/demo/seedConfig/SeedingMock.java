package com.healthApi.demo.seedConfig;

import com.healthApi.demo.entity.*;
import com.healthApi.demo.enums.Roles;
import com.healthApi.demo.repository.ExamRepository;
import com.healthApi.demo.repository.PBRepository;
import com.healthApi.demo.repository.MedicRepository;
import com.healthApi.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.time.LocalDateTime;

@Configuration
@Profile("test")
public class SeedingMock implements CommandLineRunner {
    @Autowired
    private ExamRepository examRepository;
    @Autowired
    private MedicRepository medicRepository;
    @Autowired
    private PBRepository PBRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Override
    public void run(String... args) throws Exception {

        Adress adress = new Adress("Avenue dont know",22,"Some Where","DnTKnow","11122233");

        Patient patient = new Patient("Synin Black","crowofodin@gmail.com","Diesel Malfunction", adress);

        Medic medic = new Medic(123456, "Odin", Roles.ORTHOPEDICS);


        LocalDateTime localDateTime =  LocalDateTime.of(2021,05,03,15,23);
        Exams exams = new Exams("Diesel Verification",localDateTime);


        examRepository.save(exams);
        medicRepository.save(medic);
        patientRepository.save(patient);

        ProBound bound = new ProBound(exams,patient,medic,3, Instant.parse("2023-06-20T19:53:07Z"));


        PBRepository.save(bound);

    }
}
