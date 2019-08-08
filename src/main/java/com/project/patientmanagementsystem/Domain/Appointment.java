package com.project.patientmanagementsystem.Domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Appointment implements Serializable {

    @Id
    private Long Id;

    @ManyToOne
    private Patient patient;

    @DateTimeFormat
    private Date appointmentDate;

    public Appointment() {
    }

    public Appointment(Patient patient, Date appointmentDate) {
        this.patient = patient;
        this.appointmentDate = appointmentDate;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "Id=" + Id +
                ", patient=" + patient.getFirstName() + " " +patient.getLastName() +
                ", appointmentDate=" + appointmentDate +
                '}';
    }
}
