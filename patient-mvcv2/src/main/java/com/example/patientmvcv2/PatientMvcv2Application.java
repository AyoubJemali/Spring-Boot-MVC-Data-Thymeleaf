package com.example.patientmvcv2;

import com.example.patientmvcv2.entities.Patient;
import com.example.patientmvcv2.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientMvcv2Application {

    public static void main(String[] args) {
        SpringApplication.run(PatientMvcv2Application.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null,"Hassan",new Date(),false,12));
            patientRepository.save(new Patient(null,"Mohammed",new Date(),true,32));
            patientRepository.save(new Patient(null,"Yassmine",new Date(),true,12));
            patientRepository.save(new Patient(null,"Hanae",new Date(),false,42));
            patientRepository.findAll().forEach(patient -> System.out.println(patient.getNom()));

        };
    }


}
