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
import java.util.ArrayList;
import java.util.List;

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
        Patient patient1 = new Patient("Munyn Gray","firstcrowofodin@gmail.com","Dead", adress);
        List<Patient> list = new ArrayList<>();
        list.add(patient);
        list.add(patient1);

        Medic medic = new Medic(123456, "Odin", Roles.ORTHOPEDICS);
        Medic medic2 = new Medic(1234567, "Freia", Roles.CLINICAL);
        List<Medic> list1 = new ArrayList<>();
        list1.add(medic);
        list1.add(medic2);

        LocalDateTime localDateTime =  LocalDateTime.of(2021,05,03,15,23);
        LocalDateTime localDateTime1 =  LocalDateTime.of(2023,12,25,18,38);
        Exams exams = new Exams("Diesel Verification",localDateTime);
        Exams exams1 = new Exams("Coffin checkup", localDateTime1);
        List<Exams> list2 = new ArrayList<>();
        list2.add(exams);
        list2.add(exams1);

        patientRepository.saveAll(list);
        medicRepository.saveAll(list1);
        examRepository.saveAll(list2);

        ProBound bound = new ProBound(exams,patient,medic,3, Instant.parse("2023-06-20T19:53:07Z"));
        bound.setIdentification(1L);

        PBRepository.save(bound);

    }
}
