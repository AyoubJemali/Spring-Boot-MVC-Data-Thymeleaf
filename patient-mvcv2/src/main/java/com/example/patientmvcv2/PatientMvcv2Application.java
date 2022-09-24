package com.example.patientmvcv2;

import com.example.patientmvcv2.entities.Patient;
import com.example.patientmvcv2.repositories.PatientRepository;
import com.example.patientmvcv2.sec.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class PatientMvcv2Application {

    public static void main(String[] args) {
        SpringApplication.run(PatientMvcv2Application.class, args);
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    //  @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null,"Hassan",new Date(),false,123));
            patientRepository.save(new Patient(null,"Mohammed",new Date(),true,132));
            patientRepository.save(new Patient(null,"Yassmine",new Date(),true,112));
            patientRepository.save(new Patient(null,"Hanae",new Date(),false,142));
            patientRepository.findAll().forEach(patient -> System.out.println(patient.getNom()));

        };
    }
   @Bean
    CommandLineRunner saveUsers(SecurityService securityService
    ){return args -> {
        securityService.saveNewUser("ahmed","1234","1234");
       //  securityService.saveNewUser("yasmine","1234","1234");
       //  securityService.saveNewUser("hassan","1234","1234");
       // securityService.saveNewRole("USER","");
       //  securityService.saveNewRole("ADMIN","");
       // securityService.addRoleToUser("mohamed","USER");
       //  securityService.addRoleToUser("yasmine","USER");
        securityService.addRoleToUser("ahmed","ADMIN");

    };
    }


}
