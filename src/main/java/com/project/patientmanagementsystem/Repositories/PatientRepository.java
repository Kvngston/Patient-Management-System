package com.project.patientmanagementsystem.Repositories;

import com.project.patientmanagementsystem.Domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByCardNumber(String cardNumber);
    Patient findByFirstName(String firstName);

}
