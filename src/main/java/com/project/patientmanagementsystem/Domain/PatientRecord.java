package com.project.patientmanagementsystem.Domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class PatientRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String complaint;

    private String treatments;

    @OneToOne
    private Patient patient;

    public PatientRecord() {
    }

    public PatientRecord(String complaint, String treatments, Patient patient) {
        this.complaint = complaint;
        this.treatments = treatments;
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
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
        return "PatientRecord{" +
                "id=" + id +
                ", complaint='" + complaint + '\'' +
                ", treatments='" + treatments + '\'' +
                ", patient=" + patient +
                '}';
    }
}
