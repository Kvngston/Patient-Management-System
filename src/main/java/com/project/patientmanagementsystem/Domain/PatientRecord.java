package com.project.patientmanagementsystem.Domain;

import javax.persistence.*;

@Entity
public class PatientRecord {

    @Id
    private int id;

    private String complaintList;

    private String records;

    @OneToOne
    private Patient patient;


    public PatientRecord() {
    }

    public PatientRecord(String complaintList, String records, Patient patient) {
        this.complaintList = complaintList;
        this.records = records;
        this.patient = patient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComplaintList() {
        return complaintList;
    }

    public void setComplaintList(String complaintList) {
        this.complaintList = complaintList;
    }

    public String getRecords() {
        return records;
    }

    public void setRecords(String records) {
        this.records = records;
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
                ", complaintList=" + complaintList +
                ", records=" + records +
                '}';
    }
}
