package com.project.patientmanagementsystem.Services;

import com.project.patientmanagementsystem.Domain.Appointment;
import com.project.patientmanagementsystem.Domain.Patient;
import com.project.patientmanagementsystem.Repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    //find all appointments
    public List<Appointment> lookUpAppointments(){

        return appointmentRepository.findAll();
    }

    public List<Appointment> appointmentsAtaSpecifiedTime(){

        return appointmentRepository.findAll();
    }

    public void CreateAppointment(Patient patient){
        Appointment appointment = new Appointment();
        Calendar date = Calendar.getInstance();
        //appointment.setAppointmentDate(new Date(System.currentTimeMillis()));
        System.out.println(System.currentTimeMillis());

    }
}
