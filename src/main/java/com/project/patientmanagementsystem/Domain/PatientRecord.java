package com.project.patientmanagementsystem.Domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class PatientRecord extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String treatments;

    @OneToOne
    private Patient patient;

    public PatientRecord() {
    }

    public PatientRecord(String treatments, Patient patient) {
        this.treatments = treatments;
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTreatments() {
        return treatments;
    }

    public void setTreatments(String treatments) {
        this.treatments = treatments;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", treatments=" + treatments +
                ", patient=" + patient +
                '}';
    }
}
