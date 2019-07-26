package com.project.patientmanagementsystem.Repositories;

import com.project.patientmanagementsystem.Domain.Patient;
import com.project.patientmanagementsystem.Domain.PatientRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface PatientRecordRepository extends JpaRepository<PatientRecord, Integer> {
    Set<PatientRecord> findByPatient(Patient patient);
}
