package com.project.patientmanagementsystem;

import com.project.patientmanagementsystem.Domain.Role;
import com.project.patientmanagementsystem.Repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatientmanagementsystemApplication implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    public static void main(String[] args) {
        SpringApplication.run(PatientmanagementsystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Role role = new Role();
//        role.setRole("Staff");
//        roleRepository.save(role);
    }
}
